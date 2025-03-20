import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Book {
    protected String judul;
    protected String penulis;

    public Book(String judul, String penulis) {
        this.judul = judul;
        this.penulis = penulis;
    }

    public void display() {
        System.out.println("Judul: " + judul);
        System.out.println("Penulis: " + penulis);
    }
}

class Ebook extends Book {
    private double fileSize;

    public Ebook(String judul, String penulis, double fileSize) {
        super(judul, penulis);
        this.fileSize = fileSize;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Tipe: Ebook");
        System.out.println("Ukuran file: " + fileSize + " MB");
    }
}

class BukuCetak extends Book {
    private int halaman;

    public BukuCetak(String judul, String penulis, int halaman) {
        super(judul, penulis);
        this.halaman = halaman;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Tipe: Buku Cetak");
        System.out.println("Jumlah Halaman: " + halaman);
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Integer> bookIds = new ArrayList<>();
    private int idCounter = 1;

    public void addBook(Book book) {
        books.add(book);
        bookIds.add(idCounter++);
        System.out.println("Buku berhasil ditambahkan dengan ID: " + (idCounter - 1));
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println("ID: " + bookIds.get(i));
                books.get(i).display();
                System.out.println("-------------------");
            }
        }
    }

    public void searchBook(String title) {
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).judul.equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan!");
                System.out.println("ID: " + bookIds.get(i));
                books.get(i).display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}

public class M2L1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        String[] menuOptions = {"Tambah Buku Cetak", "Tambah Ebook", "Lihat Daftar Buku", "Cari Buku", "Keluar"};

        for (;;) {
            System.out.println("\nSelamat datang di Pengelolaan Perpustakaan!");
            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println((i + 1) + ". " + menuOptions[i]);
            }
            System.out.print("Pilih menu (1/2/3/4/5): ");

            String choiceInput = scanner.nextLine();
            if (!Pattern.matches("[1-5]", choiceInput)) {
                System.out.println("Input harus berupa angka antara 1-5. Silakan coba lagi.");
                continue;
            }
            int choice = Integer.parseInt(choiceInput);

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan jumlah halaman: ");
                    String halamanInput = scanner.nextLine();
                    if (!Pattern.matches("\\d+", halamanInput)) {
                        System.out.println("Jumlah halaman harus berupa angka positif!");
                        continue;
                    }
                    int halaman = Integer.parseInt(halamanInput);
                    library.addBook(new BukuCetak (judul, penulis, halaman));
                    break;
                case 2:
                    System.out.print("Masukkan judul ebook: ");
                    String ebookJudul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String ebookPenulis = scanner.nextLine();
                    System.out.print("Masukkan ukuran file (MB): ");
                    String fileSizeInput = scanner.nextLine();
                    if (!Pattern.matches("\\d+(\\.\\d+)?", fileSizeInput)) {
                        System.out.println("Ukuran file harus berupa angka positif!");
                        continue;
                    }
                    double fileSize = Double.parseDouble(fileSizeInput);
                    library.addBook(new Ebook(ebookJudul, ebookPenulis, fileSize));
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 5:
                    System.out.println("Thanks");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid Silakan coba lagi!!");
            }
        }
    }
}
