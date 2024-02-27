import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password: ");
        String pass = sc.nextLine();

        Thread[] threads = new Thread[26];
        char letter_in_ASCII = 97;


        for (int i = 0; i < 26; i++) {
            threads[i] = new Thread(new CrackerRunnable(letter_in_ASCII, pass));
            letter_in_ASCII++;
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}