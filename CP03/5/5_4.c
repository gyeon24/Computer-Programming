#include <stdio.h>

int indexof(char *s1, char *s2){
    int i=0, j;

    while(*(s1+i) != '\0'){
        j=0;
        while(*(s2+j) != '\0' && *(s1+i+j) == *(s2+j)){
            j++;
        } 
        if(*(s2+j) == '\0'){
            return i;
        }
        i++;
    }
    return -1;
}

int main() {
	char S1[1024] = {0};
    char S2[1024] = {0};
    scanf("%s", S1);
    scanf("%s", S2);
    
    int result = indexof(S1, S2);
    printf("%d", result);
}