#include <stdio.h>

int my_atoi(char *S) {
    int r;

    for(int i=0;*(S+i) != '\0';i++){
        if(*(S+i) >= '0' && *(S+i) <= '9') r=r*10+(*(S+i)-'0');
        else{ return 0;}
    }
    
    return r;
}

int main() {
	char* S[1024] = {0};
    scanf("%s", S);
    
    int result = my_atoi(S);
    printf("%d", result);
}