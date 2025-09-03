#include <stdio.h>

typedef struct expression {
    int value1;
    int value2;
    char operator;
} Expression;

int calculator(Expression e) {
    if(e.operator == '+'){
        return e.value1 + e.value2;
    }
    else if(e.operator == '-'){
        return e.value1 - e.value2;
    }
    else if(e.operator == '*'){
        return e.value1*e.value2;
    }
    else{
        return e.value1/e.value2;
    }
}

int main(){
    int N;
    scanf("%d", &N);
    
    for (int i=0; i<N; i++){
        Expression e;
        scanf("%d %c %d", &(e.value1), &(e.operator), &(e.value2));
        
        printf("%d\n", calculator(e));
    }
    return 0;
}