import java.util.Scanner;
interface Queue {
    void enqueue(String id, String nama);
    void dequeue();
    void display();
}

class Barang {
    String id;
    String nama;

    Barang(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String toString() {
        return id + " - " + nama;
    }
}

class AntrianBarang implements Queue {
    Barang[] queue = new Barang[100];
    int head = 0, tail = 0;

    public void enqueue(String id, String nama) {
        if (tail < queue.length) {
            queue[tail++] = new Barang(id, nama);
            System.out.println("Barang berhasil ditambahkan ke antrian.");
        } else {
            System.out.println("Antrian penuh!");
        }
    }

    public void dequeue() {
        if (head == tail) {
            System.out.println("Tidak ada barang dalam antrian.");
        } else {
            System.out.println("Mengirim barang: " + queue[head]);
            queue[head] = null;
            head++;
        }
    }

}

public class M3L2Demo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianBarang antrian = new AntrianBarang();

        int pilih;
        do {
            System.out.println("\n1. Tambah Barang ");
            System.out.println("2. Tampilkan List barang");
            System.out.println("3. Kirim Barang");
            System.out.println("4. Keluar");
            System.out.print("pilih menu: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Barang: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Barang: ");
                    String nama = sc.nextLine();
                    antrian.enqueue(id, nama);
                    break;
                case 2:
                    antrian.display();
                    break;
                case 3:
                    antrian.dequeue();
                    break;
                case 4:
                    System.out.println("Thkss");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 4);
    }
}
