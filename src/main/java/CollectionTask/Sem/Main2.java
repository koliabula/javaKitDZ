package CollectionTask.Sem;

import java.util.*;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<String> names = createListNames();
        System.out.println(names);
        Set<String> setNames = new HashSet<>(names);
        System.out.println(min(setNames));
        System.out.println(maxLength(setNames));
        System.out.println(notA(setNames));
    }



    private static List<String> createListNames() {
        List<String> list = new ArrayList<>();
        list.add("Костя");
        list.add("Василий");
        list.add("Семён");
        list.add("Кирилл");
        list.add("Артём");
        list.add("Сергей");
        list.add("Артём");
        list.add("Василий");
        return list;
    }

    private static String min(Set<String> list) {
        return list.stream().min((Comparator.naturalOrder())).orElse(null);
    }
    private static String maxLength(Set<String> list){

        return list.stream().max((o1, o2) -> o1.length() - o2.length()).orElse(null);
    }

    private static Set<String> notA(Set<String> list){
        return list.stream().filter(e -> !e.toLowerCase().contains("а")).collect(Collectors.toSet());
    }
}
