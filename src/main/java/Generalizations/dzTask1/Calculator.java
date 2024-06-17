package Generalizations.dzTask1;

public class Calculator {

    public static <T extends Number> void sum(T a, T b){
        System.out.printf("%s + %s = %s\n", a, b, a.doubleValue() + b.doubleValue());
    }
    public static <T extends Number> void sub(T a, T b){
        System.out.printf("%s - %s = %s\n", a, b, a.doubleValue() - b.doubleValue());
    }

    public static <T extends Number> void mult(T a, T b){
        System.out.printf("%s * %s = %s\n", a, b, a.doubleValue() * b.doubleValue());
    }

    public static <T extends Number> void div(T a, T b){
        if(b.doubleValue() != 0) {
            System.out.printf("%s / %s = %s\n", a, b, a.doubleValue() / b.doubleValue());
        }else throw new ArithmeticException("На 0 делить нельзя");
    }

}
