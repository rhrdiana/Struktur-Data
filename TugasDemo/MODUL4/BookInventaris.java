package MODUL4;

public class BookInventaris{
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        Inventariss inventaris = new Inventariss(userManagement);
        inventaris.mulai();
    }
}