#include <iostream>

// Node structure definition
struct Node {
    int data;       // stores the value
    Node *next;     // pointer to the next node in the list

    // Constructor for quick node creation
    Node(int x) {
        data = x;
        next = NULL;
    }
};

//// -----------------
// PRINTER FUNCTION
//// -----------------

// Function to print the entire linked list
void printLL(Node *head) {
    Node *current = head;
    while (current != NULL) {
        std::cout << current->data << " -> ";
        current = current->next;
    }
    std::cout << "NULL\n";  // marks the end of the list
}

//// -----------------
// INSERTION FUNCTIONS
//// -----------------

// Insert at the beginning of the list
Node *insertAtBeginning(Node *head, int x) {
    Node *temp = new Node(x);   // create a new node
    temp->next = head;          // new node points to current head
    return temp;                // new node becomes the head
}

// Insert at the end of the list
Node *insertAtEnd(Node *head, int x) {
    Node *temp = new Node(x);   // create new node
    if (head == NULL) {         // if list is empty
        return temp;            // new node becomes head
    }
    Node *current = head;
    while (current->next != NULL) { // traverse until the last node
        current = current->next;
    }
    current->next = temp;       // link last node to new node
    return head;
}

// Insert at a specific position (1-based index)
Node *insertAtPosition(Node *head, int position, int data) {
    Node *temp = new Node(data);

    // Case 1: Insert at head
    if (position == 1) {
        temp->next = head;
        return temp;
    }

    Node *curr = head;
    // Traverse until position-1 node
    for (int i = 1; i <= position - 2 && curr != NULL; i++) {
        curr = curr->next;
    }

    if (curr == NULL) { // if position is out of range
        return head;
    }

    // Insert node in between
    temp->next = curr->next;
    curr->next = temp;
    return head;
}

//// -----------------
// DELETION FUNCTIONS
//// -----------------

// Delete node at the beginning
Node *deleteAtBeginning(Node *head) {
    if (head == NULL) { // list empty
        return NULL;
    }
    Node *temp = head;   // store current head
    head = head->next;   // move head forward
    delete temp;         // delete old head
    return head;
}

// Delete node at the end
Node *deleteAtEnd(Node *head) {
    if (head == NULL) return NULL;         // empty list
    if (head->next == NULL) {              // only one node
        delete head;
        return NULL;
    }

    Node *curr = head;
    // Traverse to the second last node
    while (curr->next->next != NULL) {
        curr = curr->next;
    }

    delete curr->next;   // delete last node
    curr->next = NULL;   // set new end
    return head;
}

// Delete node at any given position
Node *deleteAtAnyPos(Node *head, int pos) {
    if (head == NULL) return NULL; // empty list

    // Case 1: delete head
    if (pos == 1) {
        Node *temp = head;
        head = head->next;
        delete temp;
        return head;
    }

    Node *curr = head;
    // Traverse until (pos-1)th node
    for (int i = 1; i <= pos - 2 && curr != NULL; i++) {
        curr = curr->next;
    }

    // If position is invalid
    if (curr == NULL || curr->next == NULL) {
        std::cout << "Position out of range!\n";
        return head;
    }

    Node *temp = curr->next;     // node to delete
    curr->next = temp->next;     // unlink node
    delete temp;                 // free memory
    return head;
}

//// -----------------
// MAIN PROGRAM
//// -----------------

int main() {
    Node *head = nullptr;  // initially empty list
    int choice = 0, value = 0, pos = 0;

    while (choice < 8) {   // menu-driven loop
        std::cout << "\nChoose what to do?\n";
        std::cout << "1. Insert Node at the beginning\n";
        std::cout << "2. Insert Node at the end\n";
        std::cout << "3. Insert Node at any position\n";
        std::cout << "4. Delete Node at the beginning\n";
        std::cout << "5. Delete Node at the end\n";
        std::cout << "6. Delete Node at any position\n";
        std::cout << "7. Print the Linked List\n";
        std::cout << "Enter your choice: ";
        std::cin >> choice;

        switch (choice) {
            case 1:
                std::cout << "Enter your value: ";
                std::cin >> value;
                head = insertAtBeginning(head, value);
                break;

            case 2:
                std::cout << "Enter your value: ";
                std::cin >> value;
                head = insertAtEnd(head, value);
                break;

            case 3:
                std::cout << "Enter your value: ";
                std::cin >> value;
                std::cout << "Enter your position: ";
                std::cin >> pos;
                head = insertAtPosition(head, pos, value);
                break;

            case 4:
                head = deleteAtBeginning(head);
                std::cout << "Node deleted at the beginning!\n";
                break;

            case 5:
                head = deleteAtEnd(head);
                std::cout << "Node deleted at the end!\n";
                break;

            case 6:
                std::cout << "Enter position to delete: ";
                std::cin >> pos;
                head = deleteAtAnyPos(head, pos);
                break;

            case 7:
                printLL(head);
                break;

            default:
                break;
        }
    }
    return 0;
}
