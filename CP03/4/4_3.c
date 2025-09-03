#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


int main() {
    char a[50];
    char b[50];
    char c[50];
    char d[50];
    
    char* array[] = {a, b, c, d};
    char result[200];

    result[0] = '\0';

    for(int i=0;i<4;i++){
        scanf("%s", *(array + i));
    }
    for(int j=3;j>=0;j--){
        strcat(result, *(array +j));
    }
    printf("%s\n", result);

    return 0;
}