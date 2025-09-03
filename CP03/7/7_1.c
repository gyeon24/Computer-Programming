#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    char* arr[100];
    for (int i=0; i<100; i++)
    	arr[i] = (char*)malloc(sizeof(char) * 100); //similar to "arr[i] = char arr2[100]"
    char** dptr;
    
    dptr = arr;

    int N;
    scanf("%d", &N);

    if(N<1) return 0;

    for(int i=0;i<N;i++){
        scanf("%s", *(dptr+i));
    }

    for (int i = 0; i < N-1; i++) {
        for (int j = 0; j < N-1-i; j++) {
            if (strlen(*(dptr+j)) < strlen(*(dptr+j+1))) {
                char *tmp = *(dptr+j);
                *(dptr+j) = *(dptr+j+1);
                *(dptr+j+1) = tmp;   
            }
        }
    }
    
    for (int i = 0; i < N; i++) {
        printf("%s\n", *(dptr+i));
    }

    for(int i=0;i<100;i++){
        free(arr[i]);
    }

    return 0;
}