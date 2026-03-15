package dsalgo.datastructure.tree.newTree;

import dsalgo.datastructure.tree.MyTree1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author satish yadav
 * @apiNote This is the first method to create dsalgo.datastructure.tree where we are passing nodes in arrays itself
 */
public class MyTree2 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void inOrder(Node root) {
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


    public static boolean isBalanced(Node root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null && p==null && q == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left !=null && p.data < cur.left.data && q.data < cur.left.data){
                queue.add(cur.left);
            }else if(cur.right !=null && p.data > cur.right.data && q.data > cur.right.data){
                queue.add(cur.right);
            }else{
                return cur;
            }
        }

        return null;
    }

    public static boolean isValidBST(Node root) {
        return true;
    }


    public static void main(String[] args) {
        int []nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
//        int []nodes = {5,3,1,-1,2,4,-1,-1,8,7,-1,-1,9,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.idx = -1;
        Node q = BinaryTree.buildTree(new int[]{2, 4, -1, -1, 5, -1, -1});
//        boolean subtree = isSubtree(root, q);
//        System.out.println("is subtree : " + subtree);

        System.out.println(root.data);
        System.out.println("Inorder traversal is: ");
        inOrder(root);
        System.out.println("\nHeight : " + height(root));
        System.out.println("is Balanced = " + isBalanced(root));

        BinaryTree.idx = -1;
//        Node NodesForBST = BinaryTree.buildTree(new int[]{2,1,-1,-1,3,-1,-1});
//        Node NodesForBST = BinaryTree.buildTree(new int[]{1,2,-1,-1,3,-1,-1});
        Node NodesForBST = BinaryTree.buildTree(new int[]{2,2,-1,-1,2,-1,-1});
        boolean validBST = isValidBST(NodesForBST);
        System.out.println("Valid BST : " + validBST);
    }

}
