package Generalizations.dzTask3;

import java.sql.Time;

public class Pair<T extends Number, V extends String> {
    T t;
    V v;

    public Pair(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public T getFirst(){
        return t;
    }
    public V getSecond(){
        return v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t=" + getFirst() +
                ", v='" + getSecond() + '\'' +
                '}';
    }
}
