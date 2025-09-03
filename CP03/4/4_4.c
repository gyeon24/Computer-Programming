#include <stdio.h>

void count(char *s, int *c) {
    while (*s != '\0') {
        if(*s >= 'a' && *s <= 'z'){
            c[*s - 'a']++;
        }
        s++;
    }
}

int main() {
    char a[1001], b[1001];
    int ca[26] = {0}, cb[26] = {0};

    scanf("%s %s", a, b);

    count(a, ca);
    count(b, cb);

    for (int i = 0; i < 26; i++) {
        if (*(cb+i) > *(ca+i)) {
            printf("No\n");
            return 0;
        }
    }

    printf("Yes\n");
    return 0;
}
