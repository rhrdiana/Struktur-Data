package K1M5;

import java.util.Scanner;

class Node {
    String name;
    String gender;
    String relation;
    Node left;  // First child
    Node right; // Second child

    Node(String name, String gender, String relation) {
        this.name = name;
        this.gender = gender;
        this.relation = relation;
        this.left = null;
        this.right = null;
    }
}

class FamilyTree {
    Node root;
    Scanner scanner = new Scanner(System.in);

    public void addRoot() {
        System.out.println("Masukkan data untuk root (Kakek/Nenek):");
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Jenis Kelamin (Pria/Wanita): ");
        String gender = scanner.nextLine();
        System.out.print("Relasi: ");
        String relation = scanner.nextLine();
        root = new Node(name, gender, relation);
    }

    public boolean addMember() {
        System.out.print("Masukkan nama orang tua: ");
        String parentName = scanner.nextLine();
        Node parent = findNode(root, parentName);
        if (parent == null) {
            System.out.println("Orang tua dengan nama '" + parentName + "' tidak ditemukan.");
            return false;
        }

        System.out.println("Masukkan data untuk anggota keluarga baru:");
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Jenis Kelamin (Pria/Wanita): ");
        String gender = scanner.nextLine();
        System.out.print("Relasi: ");
        String relation = scanner.nextLine();

        Node newNode = new Node(name, gender, relation);
        if (parent.left == null) {
            parent.left = newNode;
            return true;
        } else if (parent.right == null) {
            parent.right = newNode;
            return true;
        } else {
            System.out.println("Orang tua '" + parentName + "' sudah memiliki 2 anak, tidak bisa menambah anak lagi.");
            return false;
        }
    }

    private Node findNode(Node current, String name) {
        if (current == null) {
            return null;
        }
        if (current.name.equalsIgnoreCase(name)) {
            return current;
        }
        Node foundNode = findNode(current.left, name);
        if (foundNode == null) {
            foundNode = findNode(current.right, name);
        }
        return foundNode;
    }

    public void printTree() {
        printTreeRec(root, "", true);
    }

    private void printTreeRec(Node node, String prefix, boolean isTail) {
        if (node == null) return;
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.name + " (" + node.relation + ", " + node.gender + ")");
        String childPrefix = prefix + (isTail ? "    " : "│   ");
        if (node.left != null || node.right != null) {
            if (node.left != null && node.right != null) {
                printTreeRec(node.left, childPrefix, false);
                printTreeRec(node.right, childPrefix, true);
            } else if (node.left != null) {
                printTreeRec(node.left, childPrefix, true);
            } else {
                printTreeRec(node.right, childPrefix, true);
            }
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print("[" + node.name + "] ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print("[" + node.name + "] ");
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print("[" + node.name + "] ");
        }
    }
}

public class K1M5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyTree familyTree = new FamilyTree();

        // Add root
        familyTree.addRoot();

        // Add family members
        while (true) {
            System.out.print("\nApakah Anda ingin menambahkan anggota keluarga? (y/n): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("y")) {
                break;
            }
            familyTree.addMember();
        }

        // Display family tree
        System.out.println("\nVisualisasi Pohon Keluarga:");
        System.out.println(familyTree.root.name + " (" + familyTree.root.relation + ", " + familyTree.root.gender + ")");
        familyTree.printTree();

        // Traversal
        System.out.println("\nPreOrder Traversal:");
        familyTree.preOrderTraversal(familyTree.root);
        System.out.println();

        System.out.println("\nInOrder Traversal:");
        familyTree.inOrderTraversal(familyTree.root);
        System.out.println();

        System.out.println("\nPostOrder Traversal:");
        familyTree.postOrderTraversal(familyTree.root);
        System.out.println();

        scanner.close();
    }
}