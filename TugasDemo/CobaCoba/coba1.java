package CobaCoba;
class Node {
    String name;
    Node left, right;

    public Node(String name) {
        this.name = name;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Fungsi untuk menambahkan node
    public void insert(String name) {
        root = insertRec(root, name);
    }

    private Node insertRec(Node root, String name) {
        if (root == null) {
            root = new Node(name);
            return root;
        }
        if (name.compareTo(root.name) < 0)
            root.left = insertRec(root.left, name);
        else if (name.compareTo(root.name) > 0)
            root.right = insertRec(root.right, name);
        return root;
    }

    // Fungsi untuk traversal PreOrder
    public void preOrder() {
        System.out.print("[");
        preOrderRec(root);
        System.out.println("]");
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.name + "] [");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Fungsi untuk traversal InOrder
    public void inOrder() {
        System.out.print("[");
        inOrderRec(root);
        System.out.println("]");
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.name + "] [");
            inOrderRec(root.right);
        }
    }

    // Fungsi untuk traversal PostOrder
    public void postOrder() {
        System.out.print("[");
        postOrderRec(root);
        System.out.println("]");
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.name + "] [");
        }
    }

    // Fungsi untuk visualisasi pohon (sederhana dengan teks)
    public void printTree() {
        System.out.println("Visualisasi Pohon Keluarga:");
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node root, int level) {
        if (root == null) return;
        printTreeRec(root.right, level + 1);
        for (int i = 0; i < level; i++) System.out.print("    ");
        System.out.println(root.name);
        printTreeRec(root.left, level + 1);
    }
}

public class coba1{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Menambahkan anggota keluarga sesuai struktur
        tree.insert("Kakek");
        tree.insert("Ayah");
        tree.insert("Saudara");
        tree.insert("Bibi");

        // Menampilkan visualisasi pohon
        tree.printTree();

        // Menampilkan hasil traversal
        System.out.println("\nPreOrder Traversal:");
        tree.preOrder();

        System.out.println("InOrder Traversal:");
        tree.inOrder();

        System.out.println("PostOrder Traversal:");
        tree.postOrder();
    }
}