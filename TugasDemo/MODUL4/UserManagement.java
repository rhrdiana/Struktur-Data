package MODUL4;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    private HashMap<String, String> users;
    private HashMap<String, ArrayList<String>> userDetails;
    private String loggedInUser;

    public UserManagement() {
        users = new HashMap<>();
        userDetails = new HashMap<>();
        loggedInUser = null;
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();

        if (!username.contains("@")) {
            System.out.println("Username harus mengandung karakter '@', coba lagi.");
            return;
        }

        if (users.containsKey(username)) {
            System.out.println("Username sudah terdaftar, coba lagi.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        if (password.length() < 8) {
            System.out.println("Password minimal 8 karakter, coba lagi.");
            return;
        }
        System.out.print("Nama Lengkap: ");
        String namaLengkap = scanner.nextLine().trim();
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine().trim();

        users.put(username, password);
        ArrayList<String> details = new ArrayList<>();
        details.add(namaLengkap);
        details.add(alamat);
        userDetails.put(username, details);
        System.out.println("Registrasi Berhasil!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedInUser = username;
            System.out.println("Login Berhasil! Selamat datang " + userDetails.get(username).get(0));
        } else {
            System.out.println("Login Gagal!");
        }
    }

    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logout Berhasil!");
            loggedInUser = null;
        } else {
            System.out.println("User belum login!");
        }
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public String getLoggedInUserName() {
        if (loggedInUser != null) {
            return userDetails.get(loggedInUser).get(0);
        }
        return null;
    }
}