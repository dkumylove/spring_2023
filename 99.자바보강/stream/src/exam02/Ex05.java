package exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex05 {
    public static void main(String[] args) {
        int[] nums = IntStream.iterate(10, x -> x + 2).limit(10).toArray();
        // iterate() : 무한스트림 : seed 값으로 연산을 통해서 반복
        System.out.println(Arrays.toString(nums));

        int[] nums2 = IntStream.generate(() -> 1).limit(10).toArray();
        // generate() : 무한스트림 : 외부에서 주어진 값으로 반복
        System.out.println(Arrays.toString(nums2));
    }
}