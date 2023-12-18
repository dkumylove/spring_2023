package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = { 11, 5, 3, 22, 15, 88, 75};

        //           IntStream         Stream<Integer>
        int[] nums2 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(x -> x).toArray();
        // boxed() : IntStream -> Stream<Integer>
        // sorted() : 정렬(기본오름차순)/( Comparator.reverseOrder() : 내림차순)

        System.out.println(Arrays.toString(nums2));
    }
}