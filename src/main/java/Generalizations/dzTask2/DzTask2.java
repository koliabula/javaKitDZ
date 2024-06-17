package Generalizations.dzTask2;

public class DzTask2 {
    public static <T> Boolean compareArrays(T[] array1, T[] array2){
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].getClass().getSimpleName().equals(array2[i].getClass().getSimpleName())){
                return false;
            }
        }return true;
    }
}
