#include <stdio.h>
#include <stdlib.h>

int main() {
	
    char* arr[10];
    for (int i=0; i<10; i++)
    	arr[i] = (char*)malloc(sizeof(char) * 10); //similar to "arr[i] = char arr2[10]"
    char** dptr;
   
    dptr = arr;

    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            scanf(" %c", &dptr[i][j]);
        }
    }

    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            if (dptr[i][j] == '*') continue;
    
            int count = 0;
    
            if (i > 0 && j > 0 && dptr[i - 1][j - 1] == '*') count++;
            if (i > 0 && dptr[i - 1][j] == '*') count++;
            if (i > 0 && j < 9 && dptr[i - 1][j + 1] == '*') count++;
            if (j > 0 && dptr[i][j - 1] == '*') count++;
            if (j < 9 && dptr[i][j + 1] == '*') count++;
            if (i < 9 && j > 0 && dptr[i + 1][j - 1] == '*') count++;
            if (i < 9 && dptr[i + 1][j] == '*') count++;
            if (i < 9 && j < 9 && dptr[i + 1][j + 1] == '*') count++;
    
            dptr[i][j] = count + '0';
            
        }
    }

    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            printf("%c ", dptr[i][j]);
        }
        printf("\n");
    }
    return 0;
}