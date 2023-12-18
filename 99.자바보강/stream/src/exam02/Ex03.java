package exam02;

import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        // 0 ~ 9
        IntStream.range(0, 10).forEach( i -> System.out.println("반복"));
        // range() : 메서드는 주어진 값의 범위에서 순차적이고 순서대로 요소 Stream을 생성하는 데 사용
        // range(시작번호, 종료 번호(미만))

        // 1 ~ 100
        int total = IntStream.rangeClosed(1, 100).sum();
        // rangeClose() : 배열의 시작 값과 끝 값을 지정하여 배열의 요소를 지정
        // rangeClosed(시작번호, 종료 번호(이하))
        System.out.println(total);
    }
}