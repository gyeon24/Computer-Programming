#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void two(unsigned int n){
    if(n == 0 || n==1) printf("%d", n);
    else{
        two(n/2);
        printf("%d", n%2);
    }
}

int main(void) {
    int N;
    scanf("%d", &N);

    unsigned int a[N];
    
    for(int i=0;i<N;i++){
        scanf("%u", (a+i));
    }

    for(int i=0;i<N;i++){
        two(*(a+i));
        printf("\n");
    }
    return 0;
}