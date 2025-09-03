#include <stdio.h>

int gcd(int,int);
int lcm(int,int);

int main() {
    int N;
    scanf("%d", &N);

    for(int i=0;i<N;i++){
        int a,b;
        scanf("%d %d", &a,&b);
        printf("%d %d\n", gcd(a,b), lcm(a,b));
    }
    return 0;
}

int gcd(int a, int b){
    if (b==0) return a;
    return gcd(b, a%b);
}
int lcm(int a, int b){
    return (a/gcd(a,b))*b;
}

