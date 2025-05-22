package K2M5;

import java.util.Scanner;

public class K2M5 {
    private static Scanner scanner = new Scanner(System.in);

    // Validation methods
    private static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    private static int getValidInteger(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Input harus antara " + min + " dan " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka valid.");
            }
        }
    }

    private static String getValidString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (isValidString(input)) {
                return input;
            }
            System.out.println("Input tidak boleh kosong.");
        }
    }

    public static void main(String[] args) {
        FilmBST filmBST = new FilmBST();
        int option;

        try {
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Film");
                System.out.println("2. Cari Film");
                System.out.println("3. Tampilkan Koleksi (InOrder)");
                System.out.println("4. Tampilkan Koleksi (PreOrder)");
                System.out.println("5. Tampilkan Koleksi (PostOrder)");
                System.out.println("6. Update/Edit Jumlah Copy Film");
                System.out.println("7. Keluar");

                option = getValidInteger("Pilih opsi: ", 1, 7);

                switch (option) {
                    case 1:
                        try {
                            String kodeProduksi = getValidString("Kode Produksi: ");
                            if (filmBST.search(kodeProduksi) != null) {
                                System.out.println("Kode produksi sudah ada! Gunakan kode lain.");
                                break;
                            }

                            String judulFilm = getValidString("Judul Film: ");
                            String genre = getValidString("Genre: ");
                            int tahunRilis = getValidInteger("Tahun Rilis: ", 1888, 2025); // First film was around 1888
                            String ratingUsia = getValidString("Rating Usia: ");
                            int jumlahCopy = getValidInteger("Jumlah Copy: ", 0, Integer.MAX_VALUE);

                            DataFilm film = new DataFilm(kodeProduksi, judulFilm, genre, tahunRilis, ratingUsia, jumlahCopy);
                            filmBST.insert(film);
                            System.out.println("Film berhasil ditambahkan!");
                        } catch (Exception e) {
                            System.out.println("Error saat menambahkan film: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            String kodeCari = getValidString("Masukkan Kode Produksi yang dicari: ");
                            DataFilm foundFilm = filmBST.search(kodeCari);
                            if (foundFilm != null) {
                                filmBST.displayFilm(foundFilm);
                            } else {
                                System.out.println("Film tidak ditemukan.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error saat mencari film: " + e.getMessage());
                        }
                        break;

                    case 3:
                        try {
                            System.out.println("Tampilkan Koleksi (InOrder):");
                            if (filmBST.root == null) {
                                System.out.println("Koleksi kosong.");
                            } else {
                                filmBST.inOrderTraversal(filmBST.root);
                            }
                        } catch (Exception e) {
                            System.out.println("Error saat menampilkan koleksi (InOrder): " + e.getMessage());
                        }
                        break;

                    case 4:
                        try {
                            System.out.println("Tampilkan Koleksi (PreOrder):");
                            if (filmBST.root == null) {
                                System.out.println("Koleksi kosong.");
                            } else {
                                filmBST.preOrderTraversal(filmBST.root);
                            }
                        } catch (Exception e) {
                            System.out.println("Error saat menampilkan koleksi (PreOrder): " + e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            System.out.println("Tampilkan Koleksi (PostOrder):");
                            if (filmBST.root == null) {
                                System.out.println("Koleksi kosong.");
                            } else {
                                filmBST.postOrderTraversal(filmBST.root);
                            }
                        } catch (Exception e) {
                            System.out.println("Error saat menampilkan koleksi (PostOrder): " + e.getMessage());
                        }
                        break;

                    case 6:
                        try {
                            String kodeUpdate = getValidString("Masukkan Kode Produksi untuk diperbarui: ");
                            int newJumlahCopy = getValidInteger("Jumlah Copy baru: ", 0, Integer.MAX_VALUE);
                            filmBST.updateJumlahCopy(kodeUpdate, newJumlahCopy);
                        } catch (Exception e) {
                            System.out.println("Error saat mengupdate jumlah copy: " + e.getMessage());
                        }
                        break;

                    case 7:
                        System.out.println("Keluar dari program.");
                        break;
                }
            } while (option != 7);
        } finally {
            scanner.close();
        }
    }
}