package exam03;

import java.util.stream.IntStream;

public class Ex01 {
    public static void main(String[] args) {
        // 1~10 출력
        IntStream.rangeClosed(1,10).forEach(System.out::println);
        System.out.println("=========");
        // 1~10 중에 앞에 5개 스킵하고 출력
        IntStream.rangeClosed(1,10).skip(5).forEach(System.out::println);

    }
}
