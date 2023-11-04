import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Выберите опцию:");
            System.out.println("1 - Добавить данные");
            System.out.println("2 - Справка");
            System.out.println("0 - Выход");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    processData();
                    break;
                case "2":
                    System.out.println("Вводите данные одной строкой через пробел.");
                    System.out.println("Фамилия Имя Отчество дата_рождения(dd.mm.yyyy)  номер_телефона(целое беззнаковое число) пол(f/m)");
                    System.out.println("Пример: \"Иванов Иван Иванович 10.03.1982 203640 m\"\n");
                    break;
                case "0":
                    isRunning = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Попробуйте снова");
            }
        }
    }


    /**
     * Обработка данных
     */
    static void processData() {
        String[] data = null;
        while (true) {
            try {
                data = inputData(6);
                checkDataFormat(data);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (DataFormatException e) {
                System.out.printf("%s: %s\n\n", e.getMessage(), e.getData());
            }
        }

        String joinedData = joinData(data);
        String fileName = data[0] + ".txt";
        addDataToFile(joinedData, fileName);
    }


    /**
     * Ввод данных
     * @param size  требуемое количество данных
     * @return
     * @throws IllegalArgumentException неверное количество данных
     */
    static String[] inputData(int size) throws IllegalArgumentException {
        System.out.println("Введите данные:");
        String[] data = scanner.nextLine().split("\\s+");
        if (data.length < size) {
            throw new IllegalArgumentException("Введено недостаточно данных\n");
        } else if (data.length > size) {
            throw new IllegalArgumentException("Введено больше данных чем требуется\n");
        } else {
            return data;
        }
    }


    /**
     * Проверка формата данных
     * @param data - массив данных
     * @throws DataFormatException Неправильный формат данных
     */
    static void checkDataFormat(String[] data) throws DataFormatException {
        String nameFormat = "^[А-Яа-яA-Za-z]{2,}$";
        String dateFormat = "\\d{2}\\.\\d{2}\\.\\d{4}";
        String phoneFormat = "\\d+";
        String genderFormat = "[fm]";

        if (!data[0].matches(nameFormat)) {
            throw new DataFormatException("Неправильный формат фамилии", data[0]);
        }
        if (!data[1].matches(nameFormat)) {
            throw new DataFormatException("Неправильный формат имени", data[1]);
        }
        if (!data[2].matches(nameFormat)) {
            throw new DataFormatException("Неправильный формат отчества", data[2]);
        }
        if (!data[3].matches(dateFormat)) {
            throw new DataFormatException("Неправильный формат даты", data[3]);
        }
        if (!data[4].matches(phoneFormat)) {
            throw new DataFormatException("Неправильный формат номера телефона", data[4]);
        }
        if (!data[5].matches(genderFormat)) {
            throw new DataFormatException("Неправильный формат пола", data[5]);
        }
    }


    /**
     * Формирование строки для записи в файл
     * @param data массив данных
     * @return строка данных
     */
    static String joinData(String[] data) {
        StringBuilder builder = new StringBuilder();
        for (String element : data) {
            builder.append("<").append(element).append(">");
        }
        return builder.toString();
    }


    /**
     * Запись строки в файл
     * @param data строка данных
     * @param fileName имя файла
     */
    static void addDataToFile(String data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(data + "\n");
            System.out.println("Данные успешно добавлены в файл " + fileName+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
