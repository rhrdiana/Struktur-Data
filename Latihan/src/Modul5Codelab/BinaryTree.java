package Modul5Codelab;

public class BinaryTree {
    Node root;
    public BinaryTree() {
        root = null;
    }

    public void addRoot(int data) {
        root = new Node(data);
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addRoot(73); // Root
        tree.root.left = new Node(41);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(25);
        tree.root.right.left = new Node(20);

        System.out.print("\nPreOrder: ");
        tree.preOrder(tree.root);

        System.out.print("\nInOrder: ");
        tree.inOrder(tree.root);

        System.out.print("\nPostOrder: ");
        tree.postOrder(tree.root);
    }
}