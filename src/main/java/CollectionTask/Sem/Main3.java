package CollectionTask.Sem;

import java.util.*;
import java.util.stream.Collectors;

public class Main3 {
    Map<Float, String> map = new HashMap<>();
    Map<Float, String> treeMap = new TreeMap<>(map);

    public static String minName(Map map){
        List<String> values = map.values().stream().toList();
        return values.stream().sorted().toList().get(values.size()-1);
    }


    public static void main(String[] args) {

        Map<Float, String> map = new HashMap<>();

        map.put(375336110311f, "Николай");
        map.put(375298910288f, "Екатерина");
        map.put(375292952712f, "Татьяна");
        map.put(375298118120f, "Наталья");

        TreeMap<Float, String> treeMap = new TreeMap<>(map); // имя с маленьким ключом
        System.out.println(treeMap.get(treeMap.firstKey())); // имя с маленьким ключом

        System.out.println(minName(map));   // самое большое имя по алфавиту



    }




}
