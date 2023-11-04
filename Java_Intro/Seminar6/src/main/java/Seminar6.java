import java.util.HashMap;
import java.util.Iterator;

// написать класс имитирующий работу hashset и хранящий int
public class Seminar6 {

    public static void main(String[] args) {
        MySet set = new MySet();
        System.out.println((set.add(1)));
        System.out.println((set.add(1)));
        System.out.println((set.add(2)));
        System.out.println((set.add(3)));
        System.out.println((set.add(4)));
        System.out.println((set.add(5)));
        System.out.println((set.remove(2)));
        System.out.println((set.remove(6)));
        System.out.println((set.isEmpty()));
        System.out.println((set.contains(1)));
        System.out.println((set.get(1)));

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.println(i);
        }

        System.out.println(set.toString());
    }
}

class MySet {
    private HashMap<Integer, Object> myMap = new HashMap<>();

    private static final Object MYOBJ = new Object();
    public boolean add(int item) {
        return myMap.put(item, MYOBJ) == null;
    }

    public boolean remove(int item) {
        return myMap.remove(item) == MYOBJ;
    }

    public boolean isEmpty() {
        return myMap.isEmpty();
    }

    public boolean contains(int item) {
        return myMap.containsKey(item);
    }

    public int get(int i) {
        Object[] a = myMap.keySet().toArray();
        return (int) a[i];
    }

    public Iterator<Integer> iterator() {
        return myMap.keySet().iterator();
    }

    public String toString(){
        return myMap.keySet().toString();
    }
}