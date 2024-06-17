package Generalizations.task2;

import java.util.Arrays;
import java.util.Iterator;

public class CollectionEx<T> implements Iterable<T> {
    private static final int DEFAULT_SIZE = 10;
    private  int size = 0;
    Object[] arrayT;

    public CollectionEx() {
        arrayT = new Object[DEFAULT_SIZE];
    }

    public void add(T t){
        if(size == arrayT.length) {
            Object[] newArray = new Object[arrayT.length + DEFAULT_SIZE];
            System.arraycopy(arrayT, 0, newArray, 0, arrayT.length);
        }
        arrayT[size++] = t;
    }

    public void delete(int index){
        System.arraycopy(arrayT,index+1,
                arrayT, index, size - index - 1);
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t: this) {
            sb.append(t + " ");
        }
        return "CollectionEx{" +
                "size=" + size +
                ", arrayT=" + "[" +
                sb + "]" +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return arrayT[index] == null ? null : (T)arrayT[index++];

            }
        };
    }
}
