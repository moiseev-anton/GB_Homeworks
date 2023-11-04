public class Program {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>(4);
        String oldValue = hashMap.put("+79124873611", "Contact1");
        oldValue = hashMap.put("+79549815722", "Contact2");
        oldValue = hashMap.put("+79914568433", "Contact3");
        oldValue = hashMap.put("+79124873611", "Contact4");
        oldValue = hashMap.put("+79913345755", "Contact5");
        oldValue = hashMap.put("+79615723566", "Contact6");
        oldValue = hashMap.put("+79315646877", "Contact7");
        oldValue = hashMap.put("+79784512588", "Contact8");
        oldValue = hashMap.put("+79215486499", "Contact9");
        oldValue = hashMap.put("+79321123300", "Contact10");
        oldValue = hashMap.put("+71324611211", "Contact11");
        System.out.println(hashMap);
    }
}
