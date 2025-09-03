#include <stdio.h>

int main() {
    char a[1001], *p = a;
    int c = 1;

    scanf("%s", a);

    while(*p != '\0'){
        if(*p == *(p+1)) c++;
        else {
            printf("%c%d", *p, c);
            c = 1;
        }
        p++;
    }

    return 0;
}
