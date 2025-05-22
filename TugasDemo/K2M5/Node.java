package K2M5;

class Node {
    DataFilm film;
    Node left, right;

    Node(DataFilm film) {
        this.film = film;
        this.left = this.right = null;
    }
}
