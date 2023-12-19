package exam03;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        // 1~100중에 홀수(x % 2 == 1, 2로 나눈 나머지가 1)
        IntStream.rangeClosed(1, 100).filter(x-> x % 2 == 1).forEach(System.out::println);

        //          1~100중에 홀수(x % 2 == 1, 2로 나눈 나머지가 1)의 합
        int total = IntStream.rangeClosed(1, 100).filter(x-> x % 2 == 1).sum();
        System.out.println("홀수의합 : " + total);
    }
}
