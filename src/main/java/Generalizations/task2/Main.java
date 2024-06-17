package Generalizations.task2;

public class Main {
    public static void main(String[] args) {
        CollectionEx<String> collectionEx = new CollectionEx<>();
        collectionEx.add("A");
        collectionEx.add("B");
        collectionEx.add("C");
        collectionEx.add("D");
        collectionEx.add("E");
        collectionEx.add("F");
        System.out.println(collectionEx);
        collectionEx.delete(3);
        System.out.println(collectionEx);
    }
}
