import java.util.Scanner;
import java.util.InputMismatchException;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(input());
    }

    static Scanner scanner = new Scanner(System.in);

    static float input(){
        float value = 0;
        while (true){
            try {
                System.out.print("Введите дробное число: ");
                value = scanner.nextFloat();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Введено не число");
                scanner.nextLine();
            }
        }
        return value;
    }
}
