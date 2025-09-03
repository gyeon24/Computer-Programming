#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int N, M, i, j;
    scanf("%d %d", &N, &M);
    int a[N][M];
    int transpose[M][N];

    for(i=0;i<N;i++){
        for(j=0;j<M;j++){
            scanf("%d ", &(a[i][j]));
        }
    }

    for(i=0;i<N;i++){
        for(j=0;j<M;j++){
            transpose[j][i] = a[i][j];
        }
    }

    for(i=0;i<M;i++){
        for(j=0;j<N;j++){
            printf("%d ", transpose[i][j]);
        }
        printf("\n");
    }
    
     return 0;
}