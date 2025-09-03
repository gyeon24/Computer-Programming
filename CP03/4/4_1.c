#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    unsigned int a[4];
    unsigned char *b[4];

    for(int i=0;i<4;i++){
        scanf("%u", (a+i));
        *(b + i) = (unsigned char *)(a + i) + (3 - i);
    }    

    unsigned int x = 0;
    for(int i=0;i<4;i++){
        x |= ((unsigned int)(unsigned char)**(b + i)) << (8 * (3 - i));
    }

    printf("%u", x);
    return 0;
}