import java.util.ArrayList;
import java.util.Scanner;

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

class PrintedBook extends Book {
    private int halaman;

    public PrintedBook(String judul, String penulis, int halaman) {
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

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Buku berhasil ditambahkan!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Daftar buku kosong.");
        } else {
            for (Book book : books) {
                book.display();
                System.out.println("-------------------");
            }
        }
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.judul.equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan!");
                book.display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Buku tidak ditemukan.");
        }
    }
}

public class L1Demo2 {
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

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String penulis = scanner.nextLine();
                    System.out.print("Masukkan jumlah halaman: ");
                    int halaman = scanner.nextInt();
                    scanner.nextLine();
                    library.addBook(new PrintedBook(judul, penulis, halaman));
                    break;
                case 2:
                    System.out.print("Masukkan judul ebook: ");
                    String ebookJudul = scanner.nextLine();
                    System.out.print("Masukkan nama penulis: ");
                    String ebookPenulis = scanner.nextLine();
                    System.out.print("Masukkan ukuran file (MB): ");
                    double fileSize = scanner.nextDouble();
                    scanner.nextLine();
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
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}