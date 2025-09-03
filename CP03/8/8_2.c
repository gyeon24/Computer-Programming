#include <stdio.h>
#include <stdlib.h>

int main() {
	
    int a[5][5];
    int *p = &a[0][0];

    for(int i=0;i<25;i++){
        scanf("%d", p+i);
    }

    int b[26] = {0};

    for(int i=0;i<25;i++){
        int n = *(p+i);

        if(n < 1 || n > 25){
            printf("no");
            return 0;
        }
        if(b[n] == 1){
            printf("no");
            return 0;
        }

        b[n] = 1;
    }

    int criz=0;
    for(int i=0;i<5;i++){
        criz += *(p+i);
    }

    for(int i=0;i<5;i++){
        int row_sum = 0;
        int *row_p = p+i*5;
        for(int j=0;j<5;j++){
            row_sum += *(row_p+j);
        }
        if(row_sum != criz){
            printf("no");
            return 0;
        }
    }    

    for(int j=0;j<5;j++){
        int col_sum = 0;
        int *col_p = p+j;
        for(int i=0;i<5;i++){
            col_sum += *(col_p+i*5);
        }
        if(col_sum != criz) {
            printf("no");
            return 0;
        }
    }

    int dia_sum1 = 0;
    for(int i=0;i<5;i++){
        dia_sum1 += *(p+i*5+i);
    }
    if(dia_sum1 != criz){
        printf("no");
        return 0;
    }

    int dia_sum2 = 0;
    for(int i=0;i<5;i++){
        dia_sum2 += *(p+i*5+(4-i));
    }
    if(dia_sum2 != criz){
        printf("no");
        return 0;
    }

    printf("yes");

    return 0;
}