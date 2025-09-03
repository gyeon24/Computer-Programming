#include <stdio.h>
#include <ctype.h>

int main(){
    char str[4];
    for(int i=0;i<4;i++){
        scanf(" %c", &str[i]);
        if (isupper(str[i])){
            str[i] = tolower(str[i]);
        } else if (islower(str[i])){
            str[i] = toupper(str[i]);
        }
        printf("%c ", str[i]);
    }
    printf("\n"); 
    return 0;
}