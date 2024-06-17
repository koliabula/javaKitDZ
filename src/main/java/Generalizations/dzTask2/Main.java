package Generalizations.dzTask2;

public class Main {
    public static void main(String[] args) {
        Object[] array1 = {0, 1, 2, 3, 4};
        Integer[] array2 = {0, 1, 2, 3, 4};
        Double[] array3 = {0.0, 1.0, 2.0, 3.0, 4.0};
        String[] array4 = {"0", "1", "2", "3", "4"};
        Object[] array5 = {0, 1, 8, 1, 4};
        Integer[] array6 = {0, 1, 2, 3};

        System.out.println(DzTask2.compareArrays(array1, array2));
        System.out.println(DzTask2.compareArrays(array1, array3));
        System.out.println(DzTask2.compareArrays(array1, array4));
        System.out.println(DzTask2.compareArrays(array2, array4));
        System.out.println(DzTask2.compareArrays(array1, array5));
        System.out.println(DzTask2.compareArrays(array1, array6));
    }
}
