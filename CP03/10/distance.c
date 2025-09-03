#include <stdio.h>
#include <math.h>

struct point {
    int x;
    int y;
} Point;

double distance(struct point p1, struct point p2){
    return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
}

int main(){
    int N;
    scanf("%d", &N);

    struct point arr[N];
    
    for (int i=0; i<N; i++){
        scanf("%d %d", &arr[i].x, &arr[i].y);
    }

    double max = 0;
    struct point p1, p2;

    for(int i=0;i<N;i++){
        for(int j=i+1;j<N;j++){
            double c = distance(arr[i], arr[j]);
            if(c > max){
                max = c;
                p1 = arr[i];
                p2 = arr[j];
            }
        }
    }

    printf("%d %d\n", p1.x, p1.y);
    printf("%d %d\n", p2.x, p2.y);
    printf("%.2f", max);
    return 0;
}