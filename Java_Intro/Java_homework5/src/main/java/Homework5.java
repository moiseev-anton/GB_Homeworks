import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что во входной структуре будут повторяющиеся имена
// с разными телефонами, их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.
public class Homework5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Вывести контакты");
            System.out.println("3. Выход");
            int mode = Integer.parseInt(in.nextLine());
            if (mode == 1) {
                addContact(phoneBook, in);
            }
            else if (mode == 2 ) {
                printContacts(phoneBook);
            }
            else break;
        }
    }

    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, Scanner in) {
        System.out.println("Введите имя");
        String name = in.nextLine();
        System.out.println("Введите номер");
        String phone = in.nextLine();

        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        }
        else {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);
        }
    }

    public static void printContacts(HashMap<String, ArrayList<String>> phoneBook) {
        // Создаем список ключей
        ArrayList<String> keyList = new ArrayList<>(phoneBook.keySet());

        // Сортируем этот список относительно количества телефонов
        Collections.sort(keyList, new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                return phoneBook.get(key2).size() - phoneBook.get(key1).size();
            }
        });

        for (String key : keyList) {
            System.out.println(key);
            for (String phone : phoneBook.get(key)) {
                System.out.println("\t" + phone);
            }
        }
        System.out.println("-----------");
    }
}
