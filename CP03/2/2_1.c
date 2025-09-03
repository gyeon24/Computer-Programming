#include <stdio.h>

int a(int,int);
int b(int,int);
int c(int,int);
int d(int,int);
int e(int,int);
int f(int,int);

int main() {
    int N;
    scanf("%d", &N);

    int x, y, r;
    char z;
    for(int i=0;i<N;i++){
        scanf("%d %d %c", &x, &y, &z);
        switch(z){
            case'+':
                r=a(x,y);
                break;
            case'-':
                r=b(x,y);
                break;
            case'*':
                r=c(x,y);
                break;
            case'/':
                r=d(x,y);
                break;
            case'%':
                r=e(x,y);
                break;
            case'^':
                r=f(x,y);
                break;
            default :
                continue;
        }
        printf("%d\n", r);
    }


    return 0;
}

int a(int x,int y){
    return x+y;
}
int b(int x,int y){
    return x-y;
}
int c(int x,int y){
    return x*y;
}
int d(int x,int y){
    return x/y;
}
int e(int x,int y){
    return x%y;
}
int f(int x,int y){
    return (int)pow(x,y);
}
