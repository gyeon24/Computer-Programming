#include <stdio.h>

typedef struct person {
    char name[20];
    int age;
    int num;
} Person;

void sort(Person arr[], int size) {
    for(int i=0;i<size-1;i++){
        int min = i;
        for(int j=i+1;j<size;j++){
            if(arr[j].age < arr[min].age || (arr[j].age == arr[min].age && arr[j].num < arr[min].num)) min = j;
        }
        if(min != i){
            struct person tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}

int main(){
    int N;
    scanf("%d", &N);

    struct person arr[N];
    
    int count=1;    
    for (int i=0; i<N; i++){
        scanf("%s %d", arr[i].name, &arr[i].age);
        arr[i].num = count;
        count++;
    }

    sort(arr, N);

    for(int i=0;i<N;i++){
        printf("%s %d %d\n", arr[i].name, arr[i].age, arr[i].num);
    }

    return 0;
}