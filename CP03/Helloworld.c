int* p = NULL;
int max_row = -1;
int max_col = -1;

////////////////////////
// 학생이 구현해야 하는 함수3
////////////////////////
void create_row() {
    int new_row = 0;
    scanf("%d%*c", &new_row);
    
    if(new_row < 0) return;

    if(max_row == -1){
        max_row = new_row;
        if(max_col == 1) max_col = 0;
        p = (int*)calloc((max_row+1)*(max_col+1), sizeof(int));
        return;
    }
    
    if(new_row <= max_row) {
        int old_row = max_row;
        max_row++;

        int* new_p = (int*)calloc((max_row+1)*(max_col+1), sizeof(int));
        for(int i = old_row; i > new_row; i--) {
            for(int j = 0; j <= max_col; j++) {
                *(new_p+(i+1)*(max_col+1)+j) = *(p+i*(max_col+1)+j);
                //*(p + i * (max_col + 1) + j) = *(p + (i - 1) * (max_col + 1) + j);
            }
        }
        for(int i = 0; i < new_row; j++) {
            for(int j=0;j<max_col;j++){
                *(new_p +i*(max_col+1)+j) = *(p+i*(max_col+1)+j);
            }
            //*(p + new_row * (max_col + 1) + j) = 0;
        }
        free(p);
        p = new_p;
    }
    else {
        int old_size = (max_row + 1) * (max_col + 1);
        max_row = new_row;
        int new_size = (max_row + 1) * (max_col + 1);
                
        int* new_p = (int*)calloc(new_size, sizeof(int));
                
        // 기존 데이터 복사
        for(int i = 0; i < old_size; i++) {
            *(new_p + i) = *(p + i);
        }
                
        free(p);
        p = new_p;
    }
}
void create_col() {
    int new_col = 0;
    scanf("%d%*c", &new_col);

    if(new_col < 0) return;
    
    // 첫 번째 생성인 경우
    if (max_col == -1) {
        max_col = new_col;
        if (max_row == -1) max_row = 0;
        p = (int*)calloc((max_row + 1) * (max_col + 1), sizeof(int));
        return;
    }

    if(new_col <= max_col){
        // 중간에 열 삽입
        int old_max_col = max_col;
        max_col++;
        int* new_p = (int*)calloc((max_row + 1) * (max_col + 1), sizeof(int));
        
        // 데이터를 새 구조로 복사
        for(int i = 0; i <= max_row; i++){
            for(int j = 0; j <= max_col; j++){
                if(j < new_col) {
                    *(new_p + i * (max_col + 1) + j) = *(p + i * (old_max_col + 1) + j);
                } else if(j == new_col) {
                    *(new_p + i * (max_col + 1) + j) = 0;
                } else {
                    *(new_p + i * (max_col + 1) + j) = *(p + i * (old_max_col + 1) + (j - 1));
                }
            }
        }
        
        free(p);
        p = new_p;
   }
   else{
        // 끝에 열 추가
        int old_max_col = max_col;
        max_col = new_col;
        int* new_p = (int*)calloc((max_row + 1) * (max_col + 1), sizeof(int));
        
        // 기존 데이터를 새 구조로 복사
        for(int i = 0; i <= max_row; i++) {
            for(int j = 0; j <= old_max_col; j++) {
                *(new_p + i * (max_col + 1) + j) = *(p + i * (old_max_col + 1) + j);
            }
        }
        
        free(p);
        p = new_p;
    }
}
long sum() {
    long sum = 0;
    for(int i=0;i<(max_row+1)*(max_col+1);i++){
        sum += *(p+i);
    }
    return sum;
}
double avg() {
    int av = (max_row+1)*(max_col+1);
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
    if(del_row < 0 || del_row > max_row || max_row < 0) return;
    
    // 마지막 행인 경우
    if(max_row == 0) {
        free(p);
        p = NULL;
        max_row = -1;
        return;
    }
    
    // 새 메모리 할당
    max_row--;
    int* new_p = (int*)calloc((max_row + 1) * (max_col + 1), sizeof(int));
    
    // 삭제할 행 위쪽 복사
    for(int i = 0; i < del_row; i++){
        for(int j = 0; j <= max_col; j++){
            *(new_p + i * (max_col + 1) + j) = *(p + i * (max_col + 1) + j);
        }
    }
    
    // 삭제할 행 아래쪽을 위로 당겨서 복사
    for(int i = del_row; i <= max_row; i++){
        for(int j = 0; j <= max_col; j++){
            *(new_p + i * (max_col + 1) + j) = *(p + (i + 1) * (max_col + 1) + j);
        }
    }
    
    free(p);
    p = new_p;
}
void delete_col() {
    int del_col;
    scanf("%d%*c", &del_col);
    if(del_col < 0 || del_col > max_col || max_col < 0) return;

    // 마지막 열인 경우
    if(max_col == 0) {
        free(p);
        p = NULL;
        max_col = -1;
        return;
    }

    // 새 메모리 할당
    int old_max_col = max_col;
    max_col--;
    int* new_p = (int*)calloc((max_row + 1) * (max_col + 1), sizeof(int));
    
    // 삭제된 열을 제외하고 데이터 복사
    for(int i = 0; i <= max_row; i++){
        int new_j = 0;
        for(int j = 0; j <= old_max_col; j++){
            if(j != del_col) {
                *(new_p + i * (max_col + 1) + new_j) = *(p + i * (old_max_col + 1) + j);
                new_j++;
            }
        }
    }
    
    free(p);
    p = new_p;
}
void save() {
    char file[256];
    scanf("%s", file);

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
