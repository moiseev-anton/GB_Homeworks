// Задание
// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Task1 {
    public static void main(String[] args) {
        StringBuilder sqlQuery = new StringBuilder("select * from students where ");
        String parameters = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        sqlQuery.append(getWhereClause(parameters));
        System.out.println(sqlQuery);
    }

    public static String getWhereClause(String jsonString){
        StringBuilder whereClause = new StringBuilder();

        jsonString = jsonString.substring(1, jsonString.length()-1)
                                .replace("\"", "")
                                .replace(":", " = '");
        String[] KeysValues = jsonString.split(", ");

        for (String pair : KeysValues){
            if (!pair.contains("'null")){
                if (whereClause.length() > 0){
                    whereClause.append(" and ");
                }
                whereClause.append(pair).append("'");
            }
        }
        return whereClause.toString();
    }
}
