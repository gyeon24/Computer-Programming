#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {
    int x, y, n;
    int a, b;
    scanf("%d %d %d", &x, &y, &n);
    scanf("%d %d", &a, &b);

    if(0>x || 0>y || 0>a || 0>b || x>19 || y>19 || a>19 || b>19 || 1> n || n>19) return 0;
    
    char plane[20][20];

    for(int i=0;i<20;i++){
        for(int j=0;j<20;j++){
            plane[i][j] = '0';
            
        }
    }
    plane[b][a] = 'A';

    for(int i = y-n/2;i<=y+n/2;i++){
        for(int j=x-n/2;j<=x+n/2;j++){
            if(i >= 0 && i<20 && j>=0 && j<20){
                plane[i][j] = 'X';
            } 
        }
    }

    if(a>=x-n/2 && a<=x+n/2 && b>=y-n/2 && b<=y+n/2) plane[b][a] = 'D';

    for(int i=0;i<20;i++){
        for(int j=0;j<20;j++){
            printf("%c ", plane[i][j]);
        }
        printf("\n");
    }
    
    return 0;
}