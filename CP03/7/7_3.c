#include <stdio.h>
#include <stdlib.h>

int main() {
	
    int image[5][5];
    int mask[3][3];
    int result[3][3];
    
    int *base = &image[0][0];
    int *filter = &mask[0][0];
    int *output = &result[0][0];

    for (int i = 0; i < 25; i++) {
        scanf("%d", base + i);
    }

    for (int i = 0; i < 9; i++) {
        scanf("%d", filter + i);
    }

    for (int i = 0; i < 9; i++) {
        *(output + i) = 0;
    }

    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            int sum = 0;
            for(int r=0;r<3;r++){
                for(int c=0;c<3;c++){
                    sum += *(base+(r+j)*5+(c+i)) * *(filter+(r*3)+ c);
                }
            }
            if(sum < 0) sum = 0;
            else if(sum>9) sum = 9;
            *(output+(j*3)+i) = sum;
        }
    }

    for (int i = 0; i < 9; i++) {
        printf("%d ", *(output + i));
        if (i % 3 == 2) printf("\n");
    }

    return 0;
}