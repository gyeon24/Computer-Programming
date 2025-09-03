#include <stdio.h>
#include <stdlib.h>

int* my_realloc(int* old, int old_size, int new_size);

int main() {
    int n,m;
    int* array;

    scanf("%d", &n);

    array = (int*)malloc(n*sizeof(int));
    for(int i=0;i<n;i++){
        scanf("%d", (array+i));
    }

    scanf("%d", &m);

    array = my_realloc(array, n,m);

    for(int i=n;i<m;i++){
        scanf("%d", (array+i));
    }

    for(int i=0;i<m;i++){
        printf("%d ", *(array+i));
    }
    free(array);

    return 0;
}

int* my_realloc(int* old_array, int old_size, int new_size){
    int *tmp = (int*)malloc(new_size*sizeof(int));

    for(int i=0;i<old_size;i++){
        *(tmp+i) = *(old_array+i);
    }
    free(old_array);

    return tmp;
}