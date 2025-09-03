#include <stdio.h>

int fib(int,int,int);

int main() {
    int N;
    scanf("%d", &N);

    if(fib(N,0,1)){
        printf("y\n");
    }else{
        printf("n\n");
    }
    return 0;
}

int fib(int n, int a, int b){
    if (b>n) return 0;
    if (b==n) return 1;
    return fib(n,b,a+b);  
}

