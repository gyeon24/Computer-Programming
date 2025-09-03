#include <stdio.h>

void math(int,int,int);

int main() {
    int N;
    scanf("%d", &N);

    int a, b, c;
    for(int i=0;i<N;i++){
        scanf("%d %d %d", &a, &b, &c);
        math(a,b,c);
    }
    return 0;
}

void math(int a,int b, int c){
    
    if((b*b-4*a*c)<0){
        printf("error\n");
        return;
    }

    float r1 = (-b + sqrt(b*b-4*a*c))/(2*a);
    float r2 = (-b - sqrt(b*b-4*a*c))/(2*a);
    printf("%.2f %.2f\n", r1, r2);
    return;
}
