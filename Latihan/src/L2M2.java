class Node{
    int value;
    Modul5Codelab.Node link;

    public Node(int value){
        this.value = value;
        this.link = null;


    }
}

public class L2M2{
    public static void main(String[] args) {
        Modul5Codelab.Node start = new Modul5Codelab.Node(8);

        Modul5Codelab.Node middle = new Modul5Codelab.Node(12);
        start.link = middle;

        Modul5Codelab.Node end = new Modul5Codelab.Node(20);
        middle.link = end;

        System.out.println("Isi Linkedlist: ");
        Modul5Codelab.Node pointer = start;
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