class Node{
    int value;
    Node link;

    public Node(int value){
        this.value = value;
        this.link = null;


    }
}

public class L2M2{
    public static void main(String[] args) {
        Node start = new Node(8);

        Node middle = new Node(12);
        start.link = middle;

        Node end = new Node(20);
        middle.link = end;

        System.out.println("Isi Linkedlist: ");
        Node pointer = start;
        while (pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.link;
        }

        System.out.println("Elemen kedua: " + start.link.value);

        start.value = 30;
        System.out.println("Isi Linkedlist setelah perubahan pada  elemen pertama : ");
        pointer = start;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.link;
        }

        start.link = start.link.link;
        System.out.println("Isi Linkedlist setelah elemen kedua dihapus: ");
        pointer = start;
        while (pointer != null){
            System.out.println(pointer.value);
            pointer = pointer.link;
        }
    }
}