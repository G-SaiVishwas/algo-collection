//This program demonstrates an implementation of an AVL Tree in Java.An AVL Tree is a self-balancing Binary Search Tree (BST).For every node, the height difference (balance factor) between the left and right subtrees is at most 1.


import java.util.Scanner;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

public class AdvancedDataStructure_AVLTree {
    Node root;

    // Get height ofnode
    int height(Node N) {
        if (N == null) return 0;
        return N.height;
    }

    // Get max otwo integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotaion
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Leftrotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Get balance facor
    int getBalance(Node N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }

    // Insertnode
    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keynot allowed

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Balance Cases
        if (balance > 1 && key < node.left.key) return rightRotate(node);
        if (balance < -1 && key > node.right.key) return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal
    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // Main program
    public static void main(String[] args) {
        AdvancedDataStructure_AVLTree tree = new AdvancedDataStructure_AVLTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== AVL Tree Implementation ===");
        System.out.print("Enter numbers separated by space: ");
        String[] input = sc.nextLine().split(" ");

        for (String s : input) {
            try {
                int key = Integer.parseInt(s.trim());
                tree.root = tree.insert(tree.root, key);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid input: " + s);
            }
        }

        System.out.println("\nIn-order traversal of AVL Tree:");
        tree.inOrder(tree.root);

        sc.close();
    }
}
