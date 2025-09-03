#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int apple(int n, int m, int x[][m]){
    int b[n+1][m+1];

    for (int i = 1; i <= n; i++){
        for (int j = 1; j <= m; j++){
            b[i][j] = x[i-1][j-1] + b[i-1][j] + b[i][j-1] - b[i-1][j-1];
        }
    }
    
    int count = 0;

    for (int i = 0; i < n * m; i++) {
        int y1 = i / m, x1 = i % m;
        for (int j = i; j < n * m; j++) {
            int y2 = j / m, x2 = j % m;
            if (y2 < y1 || x2 < x1) continue;
            int sum = b[y2+1][x2+1] - b[y2+1][x1] - b[y1][x2+1] + b[y1][x1];
            if (sum == 10) count++;
        }
    }
    return count;
}
int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    if(1 > N || N > 10 || 1 > M || M > 17) return 0;

    int a[N][M];

    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            scanf("%d", &(a[i][j]));
            if(a[i][j]<1 || a[i][j] > 9) return 0;
        }
    }

    printf("%d", apple(N, M, a));
    
    return 0;
}