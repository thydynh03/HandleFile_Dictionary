package View;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    // Hiển thị menu và trả về lựa chọn của người dùng
    public int menu() {
        System.out.println("1. Find person info.");
        System.out.println("2. Copy Text to new file.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }
public Scanner getScanner() {
        return scanner;
    }
    // Nhận đường dẫn tệp từ người dùng
    public String inputPathFile() {
        System.out.print("Enter path file: ");
        return scanner.nextLine().trim();
    }

    // Nhận số tiền từ người dùng
    public double inputMoney() {
        System.out.print("Enter money: ");
        return Double.parseDouble(scanner.nextLine().trim());
    }

    // Hiển thị thông điệp cho người dùng
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
