#include <stdio.h>
#include <stdlib.h>


#define PAGE_SIZE 1024

int* p = NULL;
int max_row = -1;
int max_col = -1;

void myfunc(int new_row, int new_col){
    int new_size = new_row*new_col;
    int* new_p = (int*)calloc(new_size, sizeof(int));

    if(new_p == NULL) return;

    if(p != NULL && max_row >= 0 && max_col >= 0){
        for(int i=0;i<=max_row && i < new_row;i++){
            for (int j = 0; j <= max_col && j < new_col; j++) {
                *(new_p + i * new_col + j) = *(p + i * (max_col + 1) + j);
            }
        }
        free(p);
    }
    p = new_p;
}

////////////////////////
// 학생이 구현해야 하는 함수3
////////////////////////
void create_row() {
    int new_row = 0;
    scanf("%d%*c", &new_row);
    
    if(new_row < 0) return;
    else if(max_row == -1){
        max_row = new_row;
        if(max_col == -1) return;
        myfunc(max_row+1, max_col+1);
        return;
    } else if(new_row <= max_row) {
        if(max_col == -1) return;
        max_row++;
        myfunc(max_row+1, max_col+1);

        for(int i=new_row ; i<=max_row ; i++){
            for(int j=0 ; j<=max_col ; j++){
                *(p + i*(max_col+1) + j) = *(p + (i+1)*(max_col+1) + j); // 값 채우기
                *(p + max_row*(max_col+1) + j) = 0; // 마지막 행 0으로 채우기
            }
        }
    } else {
        max_row = new_row;
        if(max_col == -1) return;
        myfunc(max_row+1, max_col+1);
    }
}

void create_col() {
    int new_col = 0;
    scanf("%d%*c", &new_col);
    
    if(new_col < 0) return;
    else if(max_col == -1){
        max_col = new_col;
        if(max_row == -1) return;
        myfunc(max_row+1, max_col+1);
        return;
    } else if(new_col <= max_col) {
        if(max_row == -1) return;
        max_col++;
        myfunc(max_row+1, max_col+1);

        for(int i=new_col ; i<=max_col ; i++){
            for(int j=0 ; j<=max_row ; j++){
                *(p + j*(max_col+1)+ i) = *(p + j*(max_col+1) + (i+1)); // 값 채우기
                *(p + j*(max_col+1) + max_col) = 0; // 마지막 행 0으로 채우기
            }
        }
    } else {
        max_col = new_col;
        if(max_row == -1) return;
        myfunc(max_row+1, max_col+1);
    }
}
long sum() {
    long sum = 0;
    for(int i=0 ; i<(max_row+1)*(max_col+1) ; i++){
        sum += *(p+i);
    }
    return sum;
}
double avg() {
    int av = (max_row + 1)*(max_col + 1);
    double sum=0;
    for(int i=0;i<av;i++){
        sum += *(p+i);
    }
    return sum/av;
}
void update_cell() {
    int row, col, new;
    scanf("%d %d %d%*c", &row, &col, &new);
    *(p+row*(max_col+1)+col) = new;
}
void delete_row() {
    int del_row;
    scanf("%d%*c", &del_row);

    if(del_row < 0) return;
    else if(max_row < 0) return;
    else if(del_row > max_row) return;

    if(max_row == 0) {
        max_row = -1;
        return;
    }
   
    for(int i = del_row; i < max_row; i++){
        for(int j = 0; j <= max_col; j++){
            *(p + i*(max_col + 1) + j) = *(p + (i + 1)*(max_col + 1) + j);
        }
    }
    max_row--;
    myfunc(max_row+1, max_col+1);
}
void delete_col() {
    int del_col;
    scanf("%d%*c", &del_col);

    if(del_col < 0) return;
    else if(max_col < 0) return;
    else if(del_col > max_col) return;

    if(max_col == 0) {
        max_col = -1;
        return;
    }

    for(int i = 0; i <= max_row; i++){
        for(int j = del_col; j < max_col; j++){
            *(p + i*(max_col + 1) + j) = *(p + i*(max_col + 1) + (j + 1));
        }
    }
    myfunc(max_row+1, max_col);
    max_col--;   
}
void save() {
    char file[256];
    scanf("%s%*c", file);

    FILE *f = fopen(file, "w");
    
    for(int i=0;i<max_row+1;i++){
        for(int j=0;j<max_col+1;j++){
            fprintf(f, "%d", *(p+i*(max_col+1)+j));
            if(j<max_col) fprintf(f, ",");
        }
        fprintf(f, "\n");
    }
    fclose(f);
}




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
            print_obj();
            break;
        default:
            printf("wrong command...\n");
        }
        printf("\n\n\n\n");
    }

    return 0;
}
