package data.structures;

import java.util.*;

/**
 * Binary Search Tree (BST) Implementation
 *
 * A Binary Search Tree is a binary tree where for each node, all elements in its left subtree
 * are less than the node, and all elements in its right subtree are greater than the node.
 *
 * Key characteristics:
 * - Self-balancing not implemented (average O(log n), worst case O(n))
 * - Supports insert, delete, search operations
 * - Time Complexity: O(h) where h is height of tree (log n average, n worst)
 * - Space Complexity: O(n) for n nodes
 *
 * Operations:
 * - Insert: Add a new node while maintaining BST property
 * - Search: Find if a value exists in the tree
 * - Delete: Remove a node while maintaining BST property
 */
public class BinarySearchTree {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    /**
     * Inserts a new key into the BST
     *
     * @param key Value to insert
     * @return Root of the modified tree
     */
    public Node insert(Node root, int key) {
        // If tree is empty, create new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Traverse to find insertion point
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    /**
     * Searches for a key in the BST
     *
     * @param root Root of the tree
     * @param key Value to search for
     * @return True if key exists, false otherwise
     */
    public boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    /**
     * Deletes a key from the BST
     *
     * @param root Root of the tree
     * @param key Value to delete
     * @return Root of the modified tree
     */
    public Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get inorder successor
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    /**
     * Finds the minimum value node in a BST
     */
    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    /**
     * Performs inorder traversal (left-root-right) to print sorted order
     */
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    /**
     * Main method to demonstrate BST operations
     */
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("Inorder traversal (sorted order):");
        tree.inorder(tree.root);
        System.out.println();

        // Search
        System.out.println("Search 40: " + tree.search(tree.root, 40));
        System.out.println("Search 90: " + tree.search(tree.root, 90));

        // Delete
        System.out.println("After deleting 20:");
        tree.root = tree.delete(tree.root, 20);
        tree.inorder(tree.root);
        System.out.println();
    }
}
