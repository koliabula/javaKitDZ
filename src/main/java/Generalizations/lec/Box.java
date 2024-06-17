package Generalizations.lec;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> container = new ArrayList<>();

    void add(T fruit){container.add(fruit);}

    void  print(){
        System.out.println(getWeight());
    }

    float getWeight() {
        return (container.isEmpty())
                ? 0
                :container.get(0).getWeight() * container.size();
    }

    boolean compare(Box<?> with) {
        return this.getWeight() - with.getWeight() < 0.0001;
    }

    void transferTo(Box<? super T> dest) {
        dest.container.addAll(container);
        container.clear();
    }


}
