package TeoriStrukdat;
class Node {
    int data;
    Node left;
    Node right;
    Node parent; // Untuk Tree biasa
    Node[] children; // Untuk Tree biasa

    // Constructor untuk Binary Tree dan BST
    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Constructor untuk Tree biasa
    Node(int data, int maxChildren) {
        this.data = data;
        this.children = new Node[maxChildren];
    }
}

// Implementasi Tree (Pohon Umum)
class Tree {
    Node root;
    int maxChildren;

    Tree(int maxChildren) {
        this.root = null;
        this.maxChildren = maxChildren;
    }

    // Menambahkan node baru sebagai anak dari parent
    void addNode(int parentData, int newData) {
        if (root == null) {
            root = new Node(newData, maxChildren);
            return;
        }

        Node parentNode = findNode(root, parentData);
        if (parentNode != null) {
            for (int i = 0; i < maxChildren; i++) {
                if (parentNode.children[i] == null) {
                    parentNode.children[i] = new Node(newData, maxChildren);
                    parentNode.children[i].parent = parentNode;
                    break;
                }
            }
        }
    }

    // Mencari node berdasarkan data
    Node findNode(Node current, int data) {
        if (current == null) return null;
        if (current.data == data) return current;

        for (int i = 0; i < maxChildren; i++) {
            if (current.children[i] != null) {
                Node found = findNode(current.children[i], data);
                if (found != null) return found;
            }
        }
        return null;
    }

    // Print tree secara preorder
    void printTree() {
        printTree(root, 0);
    }

    void printTree(Node node, int level) {
        if (node == null) return;
        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println(node.data);
        for (int i = 0; i < maxChildren; i++) {
            printTree(node.children[i], level + 1);
        }
    }
}

// Implementasi Binary Tree
class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Menambahkan node secara level-order
    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }

        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            if (current.left == null) {
                current.left = new Node(data);
                break;
            } else {
                queue.enqueue(current.left);
            }

            if (current.right == null) {
                current.right = new Node(data);
                break;
            } else {
                queue.enqueue(current.right);
            }
        }
    }

    // Traversal Preorder
    void preorder() {
        preorder(root);
        System.out.println();
    }

    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Traversal Inorder
    void inorder() {
        inorder(root);
        System.out.println();
    }

    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Traversal Postorder
    void postorder() {
        postorder(root);
        System.out.println();
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
}

// Implementasi Binary Search Tree
class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Menambahkan node
    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Mencari node
    boolean search(int data) {
        return searchRec(root, data);
    }

    boolean searchRec(Node root, int data) {
        if (root == null || root.data == data) {
            return root != null;
        }

        if (data < root.data) {
            return searchRec(root.left, data);
        }
        return searchRec(root.right, data);
    }

    // Menghapus node
    void delete(int data) {
        root = deleteRec(root, data);
    }

    Node deleteRec(Node root, int data) {
        if (root == null) return root;

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            // Node dengan satu anak atau tanpa anak
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node dengan dua anak
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Traversal Inorder
    void inorder() {
        inorder(root);
        System.out.println();
    }

    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

// Implementasi Queue untuk Binary Tree
class Queue {
    class QueueNode {
        Node data;
        QueueNode next;

        QueueNode(Node data) {
            this.data = data;
            this.next = null;
        }
    }

    QueueNode front, rear;

    Queue() {
        this.front = this.rear = null;
    }

    void enqueue(Node node) {
        QueueNode temp = new QueueNode(node);
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }

    Node dequeue() {
        if (this.front == null) return null;
        QueueNode temp = this.front;
        this.front = this.front.next;
        if (this.front == null) this.rear = null;
        return temp.data;
    }

    boolean isEmpty() {
        return this.front == null;
    }
}

// Main class untuk testing
public class kelasstrukdat{
    public static void main(String[] args) {
        // Testing Tree
        System.out.println("=== Testing Tree ===");
        Tree tree = new Tree(3);
        tree.addNode(0, 1);
        tree.addNode(1, 2);
        tree.addNode(1, 3);
        tree.addNode(2, 4);
        tree.printTree();

        // Testing Binary Tree
        System.out.println("\n=== Testing Binary Tree ===");
        BinaryTree bt = new BinaryTree();
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        System.out.print("Preorder: ");
        bt.preorder();
        System.out.print("Inorder: ");
        bt.inorder();
        System.out.print("Postorder: ");
        bt.postorder();

        // Testing Binary Search Tree
        System.out.println("\n=== Testing Binary Search Tree ===");
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        System.out.print("Inorder (sorted): ");
        bst.inorder();
        System.out.println("Search 40: " + bst.search(40));
        bst.delete(30);
        System.out.print("Inorder after deleting 30: ");
        bst.inorder();
    }
}