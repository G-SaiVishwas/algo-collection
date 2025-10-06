import java.util.ArrayList;
import java.util.List;

// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;
    
    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class PostorderTraversal {
    // Function to perform postorder
    // traversal recursively
    static void postorder(Node root, List<Integer> arr){
        // Base case: if root is null, return
        if(root == null){
            return;
        }
        // Traverse left subtree
        postorder(root.left, arr);
        // Traverse right subtree
        postorder(root.right, arr);
        // Visit the node
        // (append node's data to the array)
        arr.add(root.data);
    }

    // Function to get the postorder
    // traversal of a binary tree
    static List<Integer> postOrder(Node root){
        // Create a list to
        // store the traversal result
        List<Integer> arr = new ArrayList<>();
        // Perform postorder traversal
        // starting from the root
        postorder(root, arr);
        // Return the postorder
        // traversal result
        return arr;
    }

    // Function to print the
    // elements of a list
    static void printList(List<Integer> list) {
        // Iterate through the list
        // and print each element
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting postorder traversal
        List<Integer> result = postOrder(root);

        // Printing the postorder
        // traversal result
        System.out.print("Postorder traversal: ");
        printList(result);
    }
}