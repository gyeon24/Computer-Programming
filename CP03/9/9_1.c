#include <stdio.h>
#include <stdlib.h>

void result(int **arr, int N){
    int **tmp = (int**)malloc(5*sizeof(int*));
    
    for(int i=0;i<5;i++){
        tmp[i] = (int*)malloc(5*sizeof(int));
    }

    for (int r = 0; r < N % 4; r++) {
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                tmp[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[j][4 - i] = tmp[i][j];
            }
        }
    }

    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }

    free(tmp);

}

int main() {
    int N;
    scanf("%d", &N);
    int **a;
    a = (int**)malloc(5*sizeof(int*));

    for(int i=0;i<5;i++){
        a[i] = (int*) malloc(5*sizeof(int));
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            scanf("%d", &a[i][j]);
        }
    }

    result(a, N);

    free(a);

    return 0;
}