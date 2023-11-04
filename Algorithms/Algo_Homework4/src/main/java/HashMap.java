public class HashMap <K, V>  {

    //region Solution(toString)
    @Override
    public String toString() {
        String result = "";
        for (Bucket bucket: buckets) {
            if (bucket != null) {
                Bucket.Node node = bucket.head;
                while (node != null) {
                    result += String.format("%s \t %s\n", node.value.key, node.value.value);
                    node = node.next;
                }
            }
        }
        return result;
    }
    //endregion


    //region Public methods
    public V put(K key, V value){
        if (buckets.length * LOAD_FACTOR <= size) {
            recalculate();
        }
        int index = calculateBucketIndex(key);
        Bucket bucket = buckets[index];
        if (bucket == null){
            bucket = new Bucket();
            buckets[index] =bucket;
        }

        Entity entity = new Entity(key,value);

        return (V) bucket.add(entity);
    }
    //endregion


    //region Private methods
    private int calculateBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void recalculate(){
        size = 0;
        Bucket[] old = buckets;
        buckets = new Bucket[old.length*2];
        for (Bucket bucket: old) {
            if (bucket != null){
                Bucket.Node node = bucket.head;
                while (node != null) {
                    put((K)node.value.key, (V) node.value.value);
                    node = node.next;
                }
            }
        }

    }
    //endregion


    //region Constructors
    public HashMap(int initCount){
        buckets = new Bucket[initCount];
    }

    public HashMap(){
        buckets = new Bucket[INIT_BUCKET_COUNT];
    }
    //endregion


    //region Helper Structures
    class Entity {
        K key;
        V value;

        Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    class Bucket<K, V>{
        private Node head;
        class Node{
            Node next;
            Entity value;
        }

        private V add(Entity entity){
            Node newNode = new Node();
            newNode.value = entity;
            if (head == null) {
                head = newNode;
                size++;
                return null;
            }

            Node currentNode = head;
            while(true) {
                if (currentNode.value.key.equals(entity.key)){
                    V buf = (V) currentNode.value.value;
                    currentNode.value.value = entity.value;
                    return buf;
                }
                if (currentNode.next != null) {
                    currentNode = currentNode.next;
                } else {
                    currentNode.next = newNode;
                    size++;
                    return null;
                }
            }

        }
    }
    //endregion


    //region  Fields
    private Bucket[] buckets;
    private int size;
    //endregion


    //region Constants
    private static final int INIT_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.5;
    //endregion
}
