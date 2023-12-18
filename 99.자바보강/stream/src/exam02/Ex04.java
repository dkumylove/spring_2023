package exam02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random();
        //rand.ints().limit(10).forEach(System.out::println);
        rand.ints(10).forEach(System.out::println);
        //IntStream ints(); : 정수범위 난수
        //DoubleStream doubles() : 실수 범위 난수
    }
}