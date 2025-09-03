#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

void odd(int n[]);
void even(int n[]);

int main() {
    int a[10];
    for(int i=0;i<10;i++){
        scanf("%d", &a[i]);
    }

    odd(a);
    even(a);

    return 0;
}

void odd(int n[]){
    int a=1, b=0;
    for(int i=0;i<10;i++){
        if(n[i]%2 == 1){
            if(!a) printf(" ");
            printf("%d", n[i]);
            a=0;
            b=1;
        }
    }
    if(b) printf("\n");
}
    
void even(int n[]){
    int a=1, b=0;
    for(int i=0;i<10;i++) {
        if(n[i]%2 == 0){
            if(!a) printf(" ");
            printf("%d", n[i]);
            a=0;
            b=1;
        } 
    }
    if(b) printf("\n");
}