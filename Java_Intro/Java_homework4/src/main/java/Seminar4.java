import java.util.ArrayList;
import java.util.Scanner;

// Организовать вводи и хранение данных пользователей. ФИО возраст и пол
// Вывод в формате Фамилия И.О. возраст пол
// Добавить возможность выхода или вывода списка отсортированного по возрасту!)
// *Реализовать сортировку по возрасту с использованием индексов
// *Реализовать сортировку по возрасту и полу с использованием индексов
public class Seminar4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> lastnames = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<String> genders = new ArrayList<>();
        String input = "";

        while (!input.equals("Выход")) {
            System.out.println("Введите Фамилию Имя Отчество, Возраст, Пол или \"Выход\" для завершения");
            input = in.nextLine();
            if (!input.equalsIgnoreCase("выход")) {
                String[] temp = input.split(", ");
                String[] fio = temp[0].split(" ");
                lastnames.add(fio[0]);
                names.add(fio[1]);
                surnames.add(fio[2]);
                ages.add(Integer.parseInt(temp[1]));
                genders.add(temp[2]);
            }
        }

        // возможность выбора действия (если я правильно понял 3 пункт задания)
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести список");
            System.out.println("2. Вывести список, отсортированный по возрасту и полу");
            System.out.println("3. Выход");
            int mode = in.nextInt();
            if (mode == 1) {
                printData(lastnames, names, surnames, ages, genders);
            }
            else if (mode == 2 ) {
                sortDataAndPrint(lastnames, names, surnames, ages, genders);
            }
            else break;
        }
    }


    public static void printData(ArrayList<String> lastnames, ArrayList<String> names, ArrayList<String> surnames,
                                 ArrayList<Integer> ages, ArrayList<String> genders) {
        for (int i = 0; i < lastnames.size(); i++) {
            String result = lastnames.get(i) + " " +
                    names.get(i).charAt(0) + ". " +
                    surnames.get(i).charAt(0) + "., " +
                    ages.get(i) + ", " +
                    genders.get(i);
            System.out.println(result);
        }
        System.out.println("-------------");
    }


    private static void sortDataAndPrint(ArrayList<String> lastnames, ArrayList<String> names,
                                         ArrayList<String> surnames, ArrayList<Integer> ages,
                                         ArrayList<String> genders) {
        // Создаем массив индексов
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < ages.size(); i++) {
            indices.add(i);
        }

        // Сортировка сперва по полу, затем по возрасту
        for (int i = 0; i < indices.size()-1; i++) {
            for (int j = 0; j < indices.size()-1; j++) {
                int index1 = indices.get(j);
                int index2 = indices.get(j+1);
                if (genders.get(index1).compareTo(genders.get(index2)) > 0 ||
                        (genders.get(index1).equals(genders.get(index2)) && ages.get(index1) > ages.get(index2))) {
                    int temp = indices.get(j);
                    indices.set(j, indices.get(j+1));
                    indices.set(j+1, temp);
                }
            }
        }
        // Вывод в консоль
        for (int index : indices) {
            String result = lastnames.get(index) + " " +
                    names.get(index).charAt(0) + ". " +
                    surnames.get(index).charAt(0) + "., " +
                    ages.get(index) + ", " +
                    genders.get(index);
            System.out.println(result);
        }
        System.out.println("-------------");
    }
}