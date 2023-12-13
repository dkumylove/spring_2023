package exam01;

import java.util.function.Function;

public class Ex04 {
    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> x * x ;
        int result = func.apply(100);
        System.out.println(result);
    }
}
