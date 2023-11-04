import java.util.InputMismatchException;
import java.util.Scanner;

public class Task4 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            System.out.print("Введите что-нибудь: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            }
            System.out.print("Введено: " + input);
        } catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
