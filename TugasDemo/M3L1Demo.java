import java.util.*;

class Kalkulator {
    Map<String, Integer> prioritas; //key-value
    Kalkulator() {
        prioritas = new HashMap<>();
        prioritas.put("+", 1);
        prioritas.put("-", 1);
        prioritas.put("*", 2);
        prioritas.put("/", 2);
    }

    String ubahKePostfix(String infixAwal) { //shunting yard
        String infix = tambahSpasi(infixAwal);
        Stack<String> tumpukan = new Stack<>();
        String hasil = "";

        String[] token = infix.split(" ");

        for (String t : token) {
            if (t.matches("\\d+(\\.\\d+)?")) {
                hasil += t + " ";
            } else if (t.equals("(")) {
                tumpukan.push(t);
            } else if (t.equals(")")) {
                while (!tumpukan.isEmpty() && !tumpukan.peek().equals("(")) {
                    hasil += tumpukan.pop() + " ";
                }
                tumpukan.pop();
            } else if (prioritas.containsKey(t)) {
                while (!tumpukan.isEmpty() && prioritas.containsKey(tumpukan.peek()) && prioritas.get(t) <= prioritas.get(tumpukan.peek())) {
                    hasil += tumpukan.pop() + " ";
                }
                tumpukan.push(t);
            }
        }

        while (!tumpukan.isEmpty()) {
            hasil += tumpukan.pop() + " ";
        }

        return hasil.trim();
    }

    double hitungPostfix(String ekspresi) {
        Stack<Double> tumpukan = new Stack<>();
        String[] token = ekspresi.split(" ");

        for (String t : token) {
            if (t.matches("\\d+(\\.\\d+)?")) {
                tumpukan.push(Double.parseDouble(t));
            } else {
                double b = tumpukan.pop();
                double a = tumpukan.pop();
                double hasil = 0;
                switch (t) {
                    case "+": hasil = a + b; break;
                    case "-": hasil = a - b; break;
                    case "*": hasil = a * b; break;
                    case "/": hasil = a / b; break;
                }
                tumpukan.push(hasil);
            }
        }

        return tumpukan.pop();
    }

    String tambahSpasi(String ekspresi) {
        String hasil = "";
        for (int i = 0; i < ekspresi.length(); i++) {
            char c = ekspresi.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
                hasil += " " + c + " ";
            } else {
                hasil += c;
            }
        }
        return hasil.replaceAll("\\s+", " ").trim();
    }
}

public class M3L1Demo {
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        Kalkulator kalkul = new Kalkulator();

        String infix = "";
        String postfix = "";

        do {
            try {
                System.out.print("Masukin ekspresi infix (boleh tanpa spasi): ");
                infix = masuk.nextLine();
                postfix = kalkul.ubahKePostfix(infix);
                break;
            } catch (Exception e) {
                System.out.println("Ups! Formatnya salah, coba lagi ya.");
            }
        } while (true);

        System.out.println("Postfix: " + postfix);

        try {
            double hasil = kalkul.hitungPostfix(postfix);
            System.out.println("Hasil: " + hasil);
        } catch (Exception e) {
            System.out.println("Error waktu evaluasi: " + e.getMessage());
        }
    }
}
