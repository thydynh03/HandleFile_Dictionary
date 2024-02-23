package View;

import java.util.Scanner;

public class Display {
    private final Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("1. Add new word.");
        System.out.println("2. Delete word.");
        System.out.println("3. Search word.");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputEnglishWord() {
        System.out.print("Enter English: ");
        return scanner.nextLine().trim();
    }

    public String inputVietnameseMeaning() {
        System.out.print("Enter Vietnamese: ");
        return scanner.nextLine().trim();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
