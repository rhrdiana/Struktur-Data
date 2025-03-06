import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum kategori {
    NOVEL, SELF_DEVELOPMENT, TEKNOLOGI, ANAK
}

class Buku<T, U> {
    private T judul;
    private U pengarang;
    private double harga;
    private kategori kategori;

    public Buku(T judul, U pengarang, double harga, kategori kategori) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.harga = harga;
        this.kategori = kategori;
    }


    public T getJudul() {
        return judul;
    }

    public U getPengarang() {
        return pengarang;
    }

    public double getHarga() {
        return harga;
    }

    public kategori getKategori() {
        return kategori;
    }

    public void Info() {
        System.out.println("\nInformasi Buku:");
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Harga: " + harga);
        System.out.println("Kategori: " + kategori);
    }
}


public class Main {
    public static void main(String[] args) {
        List<Buku<?, ?>> daftarBuku = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah buku: ");
        int jumlahBuku = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahBuku; i++) {
            System.out.print("Masukkan Judul Buku: ");
            String judul = scanner.nextLine();

            System.out.print("Masukkan Nama Pengarang: ");
            String pengarang = scanner.nextLine();

            System.out.print("Masukkan Harga: ");
            double harga = scanner.nextDouble();

            System.out.println("Pilih Kategori: ");
            for (kategori k : kategori.values()) {
                System.out.println(k.ordinal() + ". " + k);
            }
            System.out.print("Masukkan pilihan: ");
            int kategoriIndex = scanner.nextInt();
            scanner.nextLine();

            kategori kategori1 = kategori.values()[kategoriIndex];

            daftarBuku.add(new Buku<>(judul, pengarang, harga, kategori1));
        }

        System.out.println("\nDaftar Buku:");
        display(daftarBuku);

        scanner.close();
    }

    public static void display(List<? extends Buku<?, ?>> books) {
        for (Buku<?, ?> buku : books) {
            buku.Info();
        }
    }
}
