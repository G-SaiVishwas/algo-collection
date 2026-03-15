package dsalgo.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author satish yadav
 * @apiNote This is the second method to create dsalgo. tree as par user instructed in console
 */
public class MyTree1 {

    Scanner sc = new Scanner(System.in);
    Node root;

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node createTree() {
        Node root = null;
        System.out.println("Enter data : ");
        int data = sc.nextInt();

        if (data == -1) return null;

        root = new Node(data);
        System.out.println("Enter left for : " + data);
        root.left = createTree();

        System.out.println("Enter right for : " + data);
        root.right = createTree();

        return root;
    }

    public void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curNode = q.remove();
            if (curNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curNode.data + " ");
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }

            }
        }
    }

    public int count(Node root) {
        if (root == null) {
            return 0;
        }

        int x = count(root.left);
        int y = count(root.right);

        return x + y + 1;
    }

    public int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int x = sum(root.left);
        int y = sum(root.right);

        return x + y + root.data;
    }

    public int height(Node root) {
        if (root == null) return 0;

        int leftSubTree = height(root.left);
        int rightSubTree = height(root.right);

        return Math.max(leftSubTree, rightSubTree) + 1;
    }

    public int diameter(Node root) { //it may be wrong I haven't completed yet
        if (root == null) return 0;

        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = height(root.left) + height(root.right) + 1;

        return Math.max(diameter1, diameter2);
    }
}
