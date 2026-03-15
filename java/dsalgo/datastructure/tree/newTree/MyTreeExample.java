package dsalgo.datastructure.tree.newTree;

public class  MyTreeExample {
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        MyTree2.BinaryTree tree = new MyTree2.BinaryTree();
        MyTree2.Node root = tree.buildTree(nodes);
        System.out.println(root.data);
    }
}
