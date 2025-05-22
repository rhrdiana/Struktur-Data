package K2M5;

class FilmBST {
    Node root;

    public void insert(DataFilm film) {
        root = insertRec(root, film);
    }

    private Node insertRec(Node root, DataFilm film) {
        if (root == null) {
            root = new Node(film);
            return root;
        }
        if (film.kodeProduksi.compareTo(root.film.kodeProduksi) < 0) {
            root.left = insertRec(root.left, film);
        } else if (film.kodeProduksi.compareTo(root.film.kodeProduksi) > 0) {
            root.right = insertRec(root.right, film);
        }
        return root;
    }

    public DataFilm search(String kodeProduksi) {
        return searchRec(root, kodeProduksi);
    }

    private DataFilm searchRec(Node root, String kodeProduksi) {
        if (root == null || root.film.kodeProduksi.equals(kodeProduksi)) {
            return root != null ? root.film : null;
        }
        return kodeProduksi.compareTo(root.film.kodeProduksi) < 0 ? searchRec(root.left, kodeProduksi) : searchRec(root.right, kodeProduksi);
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            displayFilm(node.film);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if (node != null) {
            displayFilm(node.film);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            displayFilm(node.film);
        }
    }

    void displayFilm(DataFilm film) {
        System.out.println("Kode Produksi: " + film.kodeProduksi);
        System.out.println("Judul Film: " + film.judulFilm);
        System.out.println("Genre: " + film.genre);
        System.out.println("Tahun Rilis: " + film.tahunRilis);
        System.out.println("Rating Usia: " + film.ratingUsia);
        System.out.println("Jumlah Copy: " + film.jumlahCopy);
        System.out.println();
    }

    public void updateJumlahCopy(String kodeProduksi, int jumlahCopy) {
        DataFilm film = search(kodeProduksi);
        if (film != null) {
            film.jumlahCopy = jumlahCopy;
            System.out.println("Jumlah copy film '" + film.judulFilm + "' berhasil diperbarui menjadi " + jumlahCopy);
        } else {
            System.out.println("Film dengan kode produksi '" + kodeProduksi + "' tidak ditemukan.");
        }
    }
}
