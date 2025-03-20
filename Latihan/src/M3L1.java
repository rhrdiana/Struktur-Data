import java.util.Stack;
public class M3L1 {
    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();
        System.out.println(myStack.isEmpty()); //true

        myStack.push("Kucing");
        myStack.push("Burung");
        myStack.push("Kelinci");
        myStack.push("Ikan");
        myStack.push("Gajah"); //top = 1

        System.out.println(myStack.get(1));

        System.out.println(myStack.isEmpty()); //false
        System.out.println("Peek: " + myStack.peek()); // menampilkan top tanpa menghapus
        System.out.println("Contents: " + myStack);

        myStack.pop();
        myStack.pop(); //hapus

        System.out.println("Contents after pop: " + myStack);

        System.out.println("Position of 'Kucing': " + myStack.search("Kucing"));
        System.out.println(myStack.get(0));
    }
}


