//Сравнить время выполнения замены символа "а" на "А" любой строки,
// содержащей >1000 символов средствами String и StringBuilder.
public class Task3 {
    public static void main(String[] args) {
        String str = "Java".repeat(1000);
        StringBuilder builder = new StringBuilder(str);

        long start = System.nanoTime();
        str = str.replace("a", "A");
        long time = System.nanoTime() - start;
        System.out.println(time + " - String");

        start = System.nanoTime();
        for (int i = 0; i < builder.length(); i++){
            if (builder.charAt(i) == 'a'){
                builder.setCharAt(i, 'A');
            }
        }
        time = System.nanoTime() - start;
        System.out.println(time + " - StringBuilder");

    }
}
