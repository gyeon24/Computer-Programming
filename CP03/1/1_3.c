#include <stdio.h>

int main() {
    int M;
    scanf("%d", &M);
    if (M <= 0 || M >= 100000000000) {
        printf("-1\n");
        return 0;
    }
    if ( M == 1){
        printf("1\n");
        return 0;
    }
    int N =0;
    int f = 1;
    while(f < M){
        N++;
        if(N>12){
            printf("-1\n");
            return 0;
        }
        if(f > M/N){
            printf("-1\n");
            return 0;
        }
        f *= N;
        if(f == M){
            printf("%d\n", N);
            return 0;
        }
        if(f> M){
            printf("-1\n");
            return 0;
        }
    }
    return 0;
}
