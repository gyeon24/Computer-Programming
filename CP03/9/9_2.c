#include <stdio.h>
#include <stdlib.h>

int main() {
    int *a;
    int input=0, i=0, size =5;
    a = (int*)malloc(5*sizeof(int));

    while(1){
        scanf("%d", &input);
        if(input == 0) break;
        if(size<=i){
            size += 5;
            a = (int*) realloc(a, size*sizeof(int));
        }
        a[i] = input;
        i++;
    }

    for(int j=i-1;j>=0;j--){
        printf("%d\n", a[j]);
    }

    free(a);

    return 0;
}