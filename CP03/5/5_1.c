#include <stdio.h>

void sum(int *p, int len){
    int m=0;
    for(int i=0;i<len;i++){
        m += *(p+i);
        printf("%d ", m);
    }
    return 0;
}

int main(){
    int N;
    scanf("%d", &N);

    int a[N];

    for(int i=0;i<N;i++){
        scanf("%d", &a[i]);
    }

    sum(a, N);

    return 0;
}