package Generalizations.task1;

import java.io.BufferedInputStream;
import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) {
        ClassTask1<String, DataInputStream, Integer> classTask1 =
                new ClassTask1<>("Text", new DataInputStream(System.in), 9);
        classTask1.printTask1();
    }
}


