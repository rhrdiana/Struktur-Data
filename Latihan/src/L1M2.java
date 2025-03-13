import java.util.ArrayList;

public class L1M2 {
    public static void main(String[] args) {
        ArrayList<String> daftarBuah = new ArrayList<>();

        daftarBuah.add("Apel");
        daftarBuah.add("Jeruk");
        daftarBuah.add("mangga");
        daftarBuah.add("Semangka");

        System.out.println("Daftar buah: ");
        for (String buah : daftarBuah){
            System.out.println(buah);
        }

        System.out.println("Elemen pada indeks 1 " + daftarBuah.get(1));

        daftarBuah.set(2, "Durian");

        System.out.println("Daftatr Buah setelah perubahan: ");
        for (String buah : daftarBuah){
            System.out.println(buah);

        }

        daftarBuah.remove(3);

        System.out.println("Daftar buah setelah penghapusan: ");
        for (String buah : daftarBuah){
            System.out.println(buah);
        }

        System.out.println("jumlah elemen dalam arraylist: " + daftarBuah.size());

        System.out.println("Apakah Arraylist kosong ? "+ daftarBuah.isEmpty());

    }
}
