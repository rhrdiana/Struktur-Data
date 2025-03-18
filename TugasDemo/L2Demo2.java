import java.util.*;

public class L2Demo2 {
    public static void main(String[] args) {
        final int SIZE = 100000;
        Random random = new Random();

        // Inisialisasi ArrayList dan LinkedList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // 1. Penyisipan di awal
        long startTime = System.nanoTime();
        arrayList.add(0, -1);
        long arrayInsertTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.add(0, -1);
        long linkedInsertTime = System.nanoTime() - startTime;

        // 2. Penghapusan di tengah
        int midIndex = SIZE / 2;

        startTime = System.nanoTime();
        arrayList.remove(midIndex);
        long arrayRemoveTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.remove(midIndex);
        long linkedRemoveTime = System.nanoTime() - startTime;

        // 3. Akses elemen acak
        int randomIndex = random.nextInt(SIZE);

        startTime = System.nanoTime();
        arrayList.get(randomIndex);
        long arrayAccessTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.get(randomIndex);
        long linkedAccessTime = System.nanoTime() - startTime;

        // Menampilkan hasil
        System.out.println("Waktu Penyisipan di Awal:");
        System.out.println("ArrayList: " + arrayInsertTime + " ns");
        System.out.println("LinkedList: " + linkedInsertTime + " ns");

        System.out.println("\nWaktu Penghapusan di Tengah:");
        System.out.println("ArrayList: " + arrayRemoveTime + " ns");
        System.out.println("LinkedList: " + linkedRemoveTime + " ns");

        System.out.println("\nWaktu Akses Acak:");
        System.out.println("ArrayList: " + arrayAccessTime + " ns");
        System.out.println("LinkedList: " + linkedAccessTime + " ns");

        // 4. Analisis (dalam komentar)
        /*
        ANALISIS:
        - Penyisipan di awal lebih cepat pada LinkedList karena hanya menyesuaikan referensi node pertama.
          Pada ArrayList, semua elemen harus digeser ke kanan, menyebabkan waktu lebih lama.
        - Penghapusan di tengah lebih efisien pada LinkedList karena hanya perlu memperbarui referensi node sebelum dan setelah elemen yang dihapus.
          ArrayList harus menggeser elemen setelahnya ke kiri.
        - Akses elemen acak jauh lebih cepat di ArrayList karena menggunakan indeks langsung (O(1)),
          sementara LinkedList harus melakukan traversal dari node pertama (O(n)).
        */
    }
}
