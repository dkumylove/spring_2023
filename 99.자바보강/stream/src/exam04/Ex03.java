package exam04;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] nums = {22, 10, 23, 5, 66, 78};

        // 첫번쨰 b = 2147483647 Integer 최고값
        int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a);

        System.out.println(min);
    }
}
