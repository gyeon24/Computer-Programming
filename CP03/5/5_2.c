#include <stdio.h>

int r(int *p, int len){
    int max = 1, count = 1;

    for(int i=1;i<len;i++){
        if(*(p+i-1) < *(p+i)){
            count++;
            if(count > max) max = count;
        } else {
            count = 1;
        }
    }

    return max;
}

int main(){
    int N;
    scanf("%d", &N);

    int a[N];

    for(int i=0;i<N;i++){
        scanf("%d", &a[i]);
    }

    int z = r(a, N);
    printf("%d", z);

    return 0;
}