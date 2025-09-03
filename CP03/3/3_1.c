#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int N, K;
    scanf("%d %d", &N, &K);
    int a[1024];
    for(int i=0;i<N;i++){
        scanf("%d", &a[i]);
    }

    for(int k=0;k<K;k++){
        int i,j;
        scanf("%d %d", &i, &j);
        if( 0<=i && 0<=j && i<N && j<N){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    for(int i = 0; i < N; i++) {
        printf("%d ", a[i]);
    }
    return 0;
}