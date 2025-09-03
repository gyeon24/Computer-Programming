#include <stdio.h>
#include <stdlib.h>

#define SIZE 5

char** delete_char(char input[SIZE][SIZE], int *new_row, int *new_col) {
    int row[SIZE] = {0};
    int col[SIZE] = {0};
    int r = SIZE; int c = SIZE;

    for(int i=0;i<SIZE;i++){
        char test = *(*(input+i)+0);
        for(int j=0;j<SIZE;j++){
            if(*(*(input+i)+j) != test){
                break;
            }
            if(j==4){
                *(row+i) = 1;
                r--;
            }
        }
    }

    for(int i=0;i<SIZE;i++){
        char test = *(*(input+0)+i);
        for(int j=0;j<SIZE;j++){
            if(*(*(input+j)+i) != test){
                break;
            }
            if(j == 4){
                *(col+i) = 1;
                c--;
            }
        }
    }

    char **result = (char**) malloc(sizeof(char*)*r);
    for(int i=0;i<r;i++){
        *(result+i) = (char *)malloc(sizeof(char)*c);
    }


    for(int i=0, ri=0;i<SIZE;i++){
        if(*(row+i) == 0){
            int rj = 0;
            for(int j=0;j<SIZE;j++){
                if(*(col+j)==0){
                    *(*(result+ri)+rj) = *(*(input+i)+j);
                    rj++;
                }
            }
        ri++;
        } 
    }

    *new_row = r;
    *new_col = c;
    return result;
}

int main() {
    char input[SIZE][SIZE];
    int new_row, new_col;

    for (int i = 0; i < SIZE; i++)
        for (int j = 0; j < SIZE; j++)
            scanf(" %c", &input[i][j]);

    char **resized = delete_char(input, &new_row, &new_col);

    if (resized != NULL) {
        for (int i = 0; i < new_row; i++) {
            for (int j = 0; j < new_col; j++) {
                printf("%c ", resized[i][j]);
            }
            printf("\n");
            free(resized[i]);
        }
        free(resized);
    }

    return 0;
}