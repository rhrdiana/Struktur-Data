package K2M5;

class DataFilm {
    String kodeProduksi;
    String judulFilm;
    String genre;
    int tahunRilis;
    String ratingUsia;
    int jumlahCopy;

    DataFilm(String kodeProduksi, String judulFilm, String genre, int tahunRilis, String ratingUsia, int jumlahCopy) {
        this.kodeProduksi = kodeProduksi;
        this.judulFilm = judulFilm;
        this.genre = genre;
        this.tahunRilis = tahunRilis;
        this.ratingUsia = ratingUsia;
        this.jumlahCopy = jumlahCopy;
    }
}
