import java.util.HashMap;
import java.util.Scanner;

class Inventaris {
    private HashMap<String, Integer> stokBuku = new HashMap<>();
    private double hargaBuku;
    private Scanner scanner = new Scanner(System.in);

    public void mulai() {
        int pilihan;

        System.out.println("\nMenu:");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Lihat Daftar Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Tambah atau Kurangi Stok");
        System.out.println("5. Hapus Buku");
        System.out.println("6. Ubah Harga");
        System.out.println("7. Keluar");

        do {
            System.out.print("Pilih (1-7): ");
            pilihan = getIntInput();

            switch (pilihan) {
                case 1: tambahBuku(); break;
                case 2: lihatDaftar(); break;
                case 3: cariBuku(); break;
                case 4: tambahStok(); break;
                case 5: hapusBuku(); break;
                case 6: ubahHarga(); break;
                case 7: System.out.println("Terima kasih!"); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 7);
        scanner.close();
    }

    private void tambahBuku() {
        System.out.print("Judul Buku: ");
        String judul = scanner.nextLine().trim();
        if (judul.isEmpty()) {
            System.out.println("Judul tidak boleh kosong!");
            return;
        }
        if (stokBuku.containsKey(judul)) {
            System.out.println("Buku sudah ada!");
            return;
        }
        int stok = getIntInput("Stok: ");
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }
        hargaBuku = getDoubleInput("Harga: ");
        if (hargaBuku < 0) {
            System.out.println("Harga tidak boleh negatif!");
            return;
        }
        stokBuku.put(judul, stok);
        System.out.println("Buku ditambahkan!");
    }

    private void lihatDaftar() {
        if (stokBuku.isEmpty()) {
            System.out.println("Inventaris kosong!");
            return;
        }
        System.out.println("\nDaftar Buku:");
        stokBuku.forEach((judul, stok) ->
                System.out.println("Judul: " + judul + ", Stok: " + stok + ", Harga: Rp " + hargaBuku));
    }

    private void cariBuku() {
        System.out.print("Judul Buku: ");
        String judul = scanner.nextLine().trim();
        if (stokBuku.containsKey(judul)) {
            System.out.println("Stok: " + stokBuku.get(judul) + ", Harga: Rp " + hargaBuku);
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    private void tambahStok() {
        System.out.print("Judul Buku: ");
        String judul = scanner.nextLine().trim();
        if (!stokBuku.containsKey(judul)) {
            System.out.println("Buku tidak ditemukan!");
            return;
        }
        System.out.print("Tambah/Kurangi Stok (contoh: +3 atau -3): ");
        String input = scanner.nextLine().trim();

        if (!input.matches("[+-]\\d+")) {
            System.out.println("Input tidak valid! Gunakan format +<angka> atau -<angka>.");
            return;
        }

        char sign = input.charAt(0);
        int value;
        try {
            value = Integer.parseInt(input.substring(1));
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid! Angka tidak valid.");
            return;
        }

        int currentStok = stokBuku.get(judul);
        int newStok = (sign == '+') ? currentStok + value : currentStok - value;

        if (newStok < 0) {
            System.out.println("Stok tidak boleh negatif! Stok saat ini: " + currentStok);
            return;
        }

        stokBuku.put(judul, newStok);
        System.out.println("Stok sekarang: " + newStok);
    }

    private void hapusBuku() {
        System.out.print("Judul Buku: ");
        String judul = scanner.nextLine().trim();
        if (stokBuku.remove(judul) != null) {
            System.out.println("Buku dihapus!");
        } else {
            System.out.println("Buku tidak ditemukan!");
        }
    }

    private void ubahHarga() {
        double harga = getDoubleInput("Harga Baru: ");
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif!");
            return;
        }
        hargaBuku = harga;
        System.out.println("Harga diubah!");
    }

    private int getIntInput() {
        return getIntInput("Pilihan: ");
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Gunakan angka.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! Gunakan angka.");
            }
        }
    }
}

public class M4L1Demo {
    public static void main(String[] args) {
        Inventaris pengelola = new Inventaris();
        pengelola.mulai();
    }
}