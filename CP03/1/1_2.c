#include <stdio.h>

int main() {

    int a, b;

    scanf("%d %d", &a, &b);

    if (a < 0 || a > 9999 || b < 0 || b > 9999) {
        printf("bound error\n");
        
        return 0;
    }

    if (a > b){
        printf("bound error\n");
        
        return 0;
    }

    int count = 0;
    
    for(int i=a;i<=b;i++){
        if((i%4 == 0 && i%100 != 0) || (i%400 == 0)){
            count ++;
        }
    }
    
    printf("%d\n", count);
    
    return 0;
}
