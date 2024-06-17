package Generalizations.task1;

import java.io.DataInput;
import java.io.InputStream;

public class ClassTask1<T extends Comparable<String>,
        V extends InputStream & DataInput,
        K extends Number> {
    T t;
    V v;
    K k;

    public ClassTask1(T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public V getV() {
        return v;
    }

    public K getK() {
        return k;
    }

    public void printTask1(){
        System.out.printf("T: %s; V: %s; K: %s;",
                t.getClass().getSimpleName(),
                v.getClass().getSimpleName(),
                k.getClass().getSimpleName());
    }
}
