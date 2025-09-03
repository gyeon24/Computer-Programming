#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PAGE_SIZE 1024

#define P_SET(i, j, val) do { \
    int __i = (i), __j = (j); \
    int __idx = __i * (max_col + 1) + __j; \
    int __total = (max_row + 1) * (max_col + 1); \
    if (__idx < 0 || __idx >= __total) { \
        printf("[ERROR] 잘못된 인덱스 쓰기: p[%d][%d] (index=%d, total=%d)\n", __i, __j, __idx, __total); \
    } else { \
        printf("[TRACE] p[%d][%d] <- %d\n", __i, __j, val); \
        *(p + __idx) = (val); \
    } \
} while(0)

int* p = NULL;
int max_row = -1;
int max_col = -1;

void myfunc(int new_row, int new_col) {
    printf("[MYFUNC DEBUG] 호출됨: new_row=%d, new_col=%d\n", new_row, new_col);
    printf("[MYFUNC DEBUG] 현재 상태: max_row=%d, max_col=%d\n", max_row, max_col);

    int* new_p = (int*)calloc(new_row * new_col, sizeof(int));
    if (new_p == NULL) return;

    if (p != NULL && max_row >= 0 && max_col >= 0) {
        int copy_row = (max_row + 1 < new_row) ? (max_row + 1) : new_row;
        int copy_col = (max_col + 1 < new_col) ? (max_col + 1) : new_col;

        for (int i = 0; i < copy_row; i++) {
            for (int j = 0; j < copy_col; j++) {
                *(new_p + i * new_col + j) = *(p + i * (max_col + 1) + j);
            }
        }
        free(p);
    }

    p = new_p;
    max_row = new_row - 1;
    max_col = new_col - 1;

    debug_memory("myfunc 할당 직후");
}

void debug_memory(const char* label) {
    if (p == NULL) {
        printf("[DEBUG: %s] 메모리가 할당되지 않았습니다.\n", label);
        return;
    }

    printf("[DEBUG: %s] 배열 상태 (max_row=%d, max_col=%d):\n", label, max_row, max_col);
    for (int i = 0; i <= max_row; i++) {
        for (int j = 0; j <= max_col; j++) {
            int value = *(p + i * (max_col + 1) + j);
            if (value != 0) {
                printf("비정상 값 발견 at (%d, %d): %d\n", i, j, value);
            }
        }
    }
}

////////////////////////
// create_row 수정버전
////////////////////////
void create_row() {
    int new_row;
    scanf("%d%*c", &new_row);
    if (new_row < 0) return;

    if (max_row == -1) {
        max_row = new_row;
        if (max_col == -1) max_col = 0;
        myfunc(max_row + 1, max_col + 1);
        return;
    }

    if (new_row <= max_row) {
        int old_row = max_row;
        int old_col = max_col;
        int* tmp = (int*)calloc((old_row + 1) * (old_col + 1), sizeof(int));
        for (int i = 0; i <= old_row; i++) {
            for (int j = 0; j <= old_col; j++) {
                tmp[i * (old_col + 1) + j] = *(p + i * (old_col + 1) + j);
            }
        }

        max_row++;
        myfunc(max_row + 1, old_col + 1);

        for (int i = old_row; i >= new_row; i--) {
            for (int j = 0; j <= old_col; j++) {
                P_SET(i + 1, j, tmp[i * (old_col + 1) + j]);
            }
        }
        for (int j = 0; j <= old_col; j++) {
            P_SET(new_row, j, 0);
        }
        free(tmp);
    } else {
        max_row = new_row;
        myfunc(max_row + 1, max_col + 1);
    }
}

void create_col() {
    int new_col;
    scanf("%d%*c", &new_col);
    printf("[CREATE_COL DEBUG] new_col=%d, max_col=%d\n", new_col, max_col);
    if (new_col < 0) return;

    if (max_col == -1) {
        printf("[CREATE_COL DEBUG] max_col이 -1이므로 첫 생성\n");
        max_col = new_col;
        if (max_row == -1) max_row = 0;
        myfunc(max_row + 1, max_col + 1);
        return;
    }

    if (new_col <= max_col) {
        printf("[CREATE_COL DEBUG] new_col <= max_col 경로 진입\n");
        int old_col = max_col;
        int row_cnt = max_row + 1;
        
        // myfunc() 호출 BEFORE에 기존 데이터를 백업
        int* tmp = (int*)calloc(row_cnt * (old_col + 1), sizeof(int));
        for (int i = 0; i < row_cnt; i++) {
            for (int j = 0; j <= old_col; j++) {
                tmp[i * (old_col + 1) + j] = *(p + i * (old_col + 1) + j);
            }
        }

        // 새로운 크기로 메모리 재할당
        max_col++;
        myfunc(row_cnt, max_col + 1);

        // 백업된 데이터를 새로운 배열에 복사
        for (int i = 0; i < row_cnt; i++) {
            for (int j = 0; j <= max_col; j++) {
                if (j == new_col) {
                    P_SET(i, j, 0);
                } else if (j < new_col) {
                    P_SET(i, j, tmp[i * (old_col + 1) + j]);
                } else {
                    P_SET(i, j, tmp[i * (old_col + 1) + (j - 1)]);
                }
            }
        }
        free(tmp);
    } else {
        printf("[CREATE_COL DEBUG] else 경로 진입 (단순 확장)\n");
        max_col = new_col;
        myfunc(max_row + 1, max_col + 1);
    }
}

long sum() {
    long sum = 0;
    for(int i = 0; i < (max_row + 1) * (max_col + 1); i++){
        sum += *(p + i);
    }
    return sum;
}

double avg() {
    int av = (max_row + 1) * (max_col + 1);
    double sum = 0;
    for(int i = 0; i < av; i++){
        sum += *(p + i);
    }
    return sum / av;
}

void update_cell() {
    int row, col, new;
    scanf("%d %d %d%*c", &row, &col, &new);
    P_SET(row, col, new);
}

void delete_row() {
    int del_row;
    scanf("%d%*c", &del_row);
    if (del_row < 0 || del_row > max_row) return;

    int old_row = max_row;
    int old_col = max_col;
    int* tmp = (int*)calloc((old_row + 1) * (old_col + 1), sizeof(int));
    for (int i = 0; i <= old_row; i++) {
        for (int j = 0; j <= old_col; j++) {
            tmp[i * (old_col + 1) + j] = *(p + i * (old_col + 1) + j);
        }
    }

    max_row--;
    myfunc(max_row + 1, old_col + 1);

    for (int i = 0; i <= max_row; i++) {
        int src_i = (i < del_row) ? i : i + 1;
        for (int j = 0; j <= old_col; j++) {
            P_SET(i, j, tmp[src_i * (old_col + 1) + j]);
        }
    }

    free(tmp);
}

void delete_col() {
    int del_col;
    scanf("%d%*c", &del_col);
    if (del_col < 0 || del_col > max_col) return;

    int old_col = max_col;
    int old_row = max_row;
    int* tmp = (int*)calloc((old_row + 1) * (old_col + 1), sizeof(int));
    for (int i = 0; i <= old_row; i++) {
        for (int j = 0; j <= old_col; j++) {
            tmp[i * (old_col + 1) + j] = *(p + i * (old_col + 1) + j);
        }
    }

    max_col--;
    myfunc(old_row + 1, max_col + 1);

    for (int i = 0; i <= old_row; i++) {
        for (int j = 0; j <= max_col; j++) {
            int src_j = (j < del_col) ? j : j + 1;
            P_SET(i, j, tmp[i * (old_col + 1) + src_j]);
        }
    }

    free(tmp);
}

void save() {
    char file[256];
    scanf("%s", file);

    FILE *f = fopen(file, "w");
    if (f == NULL) {
        printf("[ERROR] 파일 열기 실패: %s\n", file);
        return;
    }
    
    for(int i=0; i<max_row+1; i++){
        for(int j=0; j<max_col+1; j++){
            fprintf(f, "%d", *(p + i*(max_col+1) + j));
            if(j<max_col) fprintf(f, ",");
        }
        fprintf(f, "\n");
    }
    fclose(f);  
}

// 아래 main 함수 등은 그대로 사용하시면 됩니다.


///////////////////////////////
// 아래 코드는 기존에 주어진 코드
///////////////////////////////

void create_obj() {
    printf("create new (r)ow | (c)olumn\n");
    printf("input your command: \n");
    char c;
    scanf("%c", &c);
    while(getchar() !='\n');
    switch (c)
    {
    case 'r':
        printf("input row num: ");
        create_row();
        break;
    case 'c':
        printf("input column num: ");
        create_col();
        break;
    default:
        printf("wrong command...\n");
    }
}

void functions() {
    printf("apply function (a)verage | (s)um\n");
    printf("input your command: \n");
    char c;
    scanf("%c", &c);
    while(getchar() !='\n');
    switch (c)
    {
    case 'a':
        printf("average: %f\n", avg());
        break;
    case 's':
        printf("sum: %ld", sum());
        break;
    default:
        printf("wrong command...\n");
    }
}

void delete_obj() {
    printf("delete (r)ow | (c)olumn\n");
    printf("input your command: \n");
    char c;
    scanf("%c", &c);
    while(getchar() !='\n');
    switch (c)
    {
    case 'r':
        printf("input row num: ");
        delete_row();
        break;
    case 'c':
        printf("input column num: ");
        delete_col();
        break;
    default:
        printf("wrong command...\n");
    }
}

void print_obj() {
    if (max_row==-1 || max_col==-1) return;
    printf("           ");
    for (int i=0; i<max_col+1; i++) {
        printf(" %11d", i);
    }
    printf("\n           ");
    for (int i=0; i<max_col+1; i++) {
        printf("------------");
    }
    printf("-\n");
    for (int i=0; i<max_row+1; i++) {
        printf("%11d", i);
        for (int j=0; j<max_col+1; j++) {
            printf("|%11d", *(p + ((max_col+1)*i) + j));
        }
        printf("|\n");
    }
    printf("           ");
    for (int i=0; i<max_col+1; i++) {
        printf("------------");
    }
    printf("-\n");
}

void print_intro() {
    printf("#################################################\n");
    printf("#\t\t2025 CP3 mini project\t\t#\n");
    printf("#################################################\n");
    printf("\n");
    printf("(c)reate | (f)unction | (u)pdate | (d)elete | (s)ave | (p)rint | (q)uit\n");
    printf("input your command: \n");
}

int main() {
    int loop = 1;
    while (loop) {
        print_intro();
        
        char c;
        scanf("%c", &c);
        while(getchar() !='\n');
        
        switch (c)
        {
        case 'c':
            create_obj();
            break;
        case 'f':
            functions();
            break;
        case 'u':
            printf("input row and column num & data: ");
            update_cell();
            break;
        case 'd':
            delete_obj();
            break;
        case 's':
            printf("input filename: ");
            save();
            break;
        case 'q':
            loop = 0;
            break;
        case 'p':
        //
            debug_memory("print 전에 상태 확인");
            print_obj();
            break;
        default:
            printf("wrong command...\n");
        }
        printf("\n\n\n\n");
    }

    return 0;
}
