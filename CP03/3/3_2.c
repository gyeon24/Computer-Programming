#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char str[100];
    scanf("%[^\n]s", str);

    for(int i=0;str[i] != '\0';i++){
        if(str[i] != ' '){
            printf("%c", str[i]);
        }
    }
        
    return 0;
}