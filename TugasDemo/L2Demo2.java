import java.util.*;

public class L2Demo2 {
    public static void main(String[] args) {
        final int SIZE = 100000;
        Random random = new Random();

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long startTime = System.nanoTime();
        arrayList.add(0, -1);
        long arrayInsertTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.add(0, -1);
        long linkedInsertTime = System.nanoTime() - startTime;

        int midIndex = SIZE / 2;

        startTime = System.nanoTime();
        arrayList.remove(midIndex);
        long arrayRemoveTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.remove(midIndex);
        long linkedRemoveTime = System.nanoTime() - startTime;

        int randomIndex = random.nextInt(SIZE);

        startTime = System.nanoTime();
        arrayList.get(randomIndex);
        long arrayAccessTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.get(randomIndex);
        long linkedAccessTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        arrayList.add(midIndex, -1);
        long arrayInsertMidTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        linkedList.add(midIndex, -1);
        long linkedInsertMidTime = System.nanoTime() - startTime;

        long memoryAfterArray = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long memoryAfterLinked = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("Waktu Penyisipan di Awal:");
        System.out.println("ArrayList: " + arrayInsertTime + " ns");
        System.out.println("LinkedList: " + linkedInsertTime + " ns");

        System.out.println("\nWaktu Penyisipan di Tengah:");
        System.out.println("ArrayList: " + arrayInsertMidTime + " ns");
        System.out.println("LinkedList: " + linkedInsertMidTime + " ns");

        System.out.println("\nWaktu Penghapusan di Tengah:");
        System.out.println("ArrayList: " + arrayRemoveTime + " ns");
        System.out.println("LinkedList: " + linkedRemoveTime + " ns");

        System.out.println("\nWaktu Akses Acak:");
        System.out.println("ArrayList: " + arrayAccessTime + " ns");
        System.out.println("LinkedList: " + linkedAccessTime + " ns");

        System.out.println("\nPerbandingan konsumsi memori:");
        System.out.println("ArrayList: " + memoryAfterArray + " bytes");
        System.out.println("LinkedList: " + memoryAfterLinked + " bytes");

        /*
        Penjelasan dari Experiment:
        1. Penyisipan di awal lebih cepat pada LinkedList karena hanya mengubah referensi node,
           sedangkan ArrayList harus menggeser semua elemen.
        2. Penyisipan di tengah cenderung lebih lambat di LinkedList karena harus menelusuri node.
        3. Penghapusan di tengah lebih cepat di ArrayList karena akses langsung berdasarkan indeks,
           sementara LinkedList harus menelusuri node satu per satu.
        4. Akses elemen acak jauh lebih cepat pada ArrayList karena menggunakan indeks langsung (O(1)),
           sedangkan LinkedList membutuhkan traversal node (O(n)).
        5. Konsumsi memori LinkedList lebih besar karena menyimpan referensi node berikut dan sebelumnya.
        */
    }
}
