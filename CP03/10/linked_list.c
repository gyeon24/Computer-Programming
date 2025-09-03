#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int item;
    struct node* next;
} Node;

void insert(Node** head, int item) {
    Node* new = (Node*)malloc(sizeof(Node));
    new->item = item;
    new->next = *head;
    *head = new;    
}

void print(Node* head){
    Node *p = head;
    while(p != NULL){
        printf("%d\n", p->item);
        p = p->next;
    }
}

void freeList(Node* head){
    Node* p = head;
    while(p != NULL){
        Node *tmp = p;
        p=p->next;
        free(tmp);
    }
}

int main(){
    Node* head = NULL;
    int e;
    while(1){
        scanf("%d", &e);
        if(e == 0) break;
        insert(&head, e);
    }
    print(head);
    freeList(head);
    return 0;
}