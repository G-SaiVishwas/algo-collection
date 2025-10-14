// Stack implemented using Array
#include <stdio.h>
#include <stdbool.h>

#define MAX_SIZE 100  // Maximum size of the stack

// Define a Stack structure using typedef
typedef struct {
    int arr[MAX_SIZE];  // Array to hold stack elements
    int top;            // Index of the top element
} Stack;

// Initialize stack
void initializeStack(Stack *node) {
    node->top = -1;  // Empty stack when top = -1
}

// Check if the stack is empty
bool isStackEmpty(Stack *node) {
    return node->top == -1;
}

// Check if the stack is full
bool isStackFull(Stack *node) {
    return node->top == MAX_SIZE - 1;
}

// Push an element onto the stack
void push(Stack *node, int value) {
    if (isStackFull(node)) {
        printf("Stack Overflow\n");
        return;
    }

    node->arr[++node->top] = value;
    printf("Pushed %d onto stack!\n", value);
}

// Pop an element from the stack
int pop(Stack *node) {
    if (isStackEmpty(node)) {
        printf("Stack Underflow\n");
        return -1;  // Return invalid value for empty stack
    }

    int popped = node->arr[node->top--];
    printf("%d popped from the stack!\n", popped);
    return popped;
}

// Peek (view) the top element of the stack without removing it
int peek(Stack *node) {
    if (isStackEmpty(node)) {
        printf("Stack is empty.\n");
        return -1;
    }

    return node->arr[node->top];
}

// Print all elements of the stack
void printStack(Stack *node) {
    if (isStackEmpty(node)) {
        printf("Stack is empty.\n");
        return;
    }

    printf("Stack elements (top to bottom): ");
    for (int i = node->top; i >= 0; i--) {
        printf("%d ", node->arr[i]);
    }
    printf("\n");
}

// Driver function
int main() {
    Stack stack;
    initializeStack(&stack);

    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);

    printStack(&stack);

    printf("Top element is: %d\n", peek(&stack));

    pop(&stack);
    printStack(&stack);

    return 0;
}