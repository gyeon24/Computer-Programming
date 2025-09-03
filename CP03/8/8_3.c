#include <stdio.h>
#include <stdlib.h>

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    int a[N][M];
    int *p = &a[0][0];

    for(int i=0;i<N*M;i++){
        scanf("%d", p+i);
    }

    double row_mid[2][N];
    double (*t)[N] = row_mid;

    for(int i=0;i<N;i++){
        double sum=0;
        for(int j=0;j<M;j++){
            sum += *(p+i*M+j);
        }
        *(*(t) + i) = sum/M;
        *(*(t + 1) + i) = i;
    }

    for(int i=0;i<N-1;i++){
        for(int j=0;j<N-1-i;j++){
            double *a0 = (*(t+0) + j);
            double *a1 = (*(t+1) + j);
            double *b0 = (*(t + 0) + j + 1);
            double *b1 = (*(t + 1) + j + 1);

            if (*a0 > *b0) {
                double tmp = *a0;
                *a0 = *b0;
                *b0 = tmp;

                tmp = *a1;
                *a1 = *b1;
                *b1 = tmp;
            }
        }
    }

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            printf("%d ", *(p+(int)(*(*(t+1)+i))*M+j));
            
        }
        printf("\n");
    }
    return 0;
}