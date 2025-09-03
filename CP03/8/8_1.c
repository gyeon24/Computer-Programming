#include <stdio.h>
#include <stdlib.h>

int main() {
	
    char odelo[10][10];
    char (*ant) [10] = odelo;

    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            odelo[i][j] = '.';
        }
    }

    int s;
    scanf("%d", &s);

    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    int *px = dx;
    int *py = dy;

    int x=0, y=0, l=0;

    if(s >= 0) *(*(ant+x)+y) = '#';

    for(int i=1;i<=s;i++){
        int a = x+*(px + l);
        int b = y+*(py + l);

        if(a<0 || a >= 10 || b<0 || b >= 10 || *(*(ant + a)+b)=='#'){
            l = (l+1)%4;
            a = x + *(dx + l);
            b = y + *(dy + l);
        }

        x=a;
        y=b;
        *(*(ant + x)+y) = '#';
    }

    for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            printf("%c", *(*(ant+i)+j));
        }
        printf("\n");
    }

    return 0;
}