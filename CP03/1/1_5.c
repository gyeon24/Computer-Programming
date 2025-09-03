#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int G;
    scanf("%d", &G);

    if(G <= 0 && G >= 130){
        return 0;
    }

    int a = 0;

    a += G/3;
    G= G%3;
    a += G/2;
    G=G%2;
    a += G;
    printf("%d\n", a);

    return 0;
}