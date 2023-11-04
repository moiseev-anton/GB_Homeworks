// Дана json-строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

public class Task2 {
    public static void main(String[] args) {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        System.out.println(parsingJson(jsonString));
    }

    public static String parsingJson (String jsonStr){
        jsonStr = jsonStr.substring(2,jsonStr.length()-2)
                .replace("\"","")
                .replace("фамилия:","")
                .replace("оценка:","")
                .replace("предмет:","");

        StringBuilder resultBuilder = new StringBuilder();
        String[] dataArray = jsonStr.split("},\\{");

        for (String data : dataArray){
            if (!data.contains("null")) {
                String[] values = data.split(",");
                resultBuilder.append("Студент ")
                        .append(values[0])
                        .append(" получил ")
                        .append(values[1])
                        .append(" по предмету ")
                        .append(values[2])
                        .append(".\n");
            }
        }
        return resultBuilder.toString();
    }
}
