package exam04;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class Ex04 {
    public static void main(String[] args) {
        int[] nums = {22, 10, 23, 5, 66, 78};

        // 첫번째 a 값 기준값 = 배열의 첫번째 값
        OptionalInt opt = Arrays.stream(nums).reduce((acc, num) -> {
            System.out.printf("acc=%d, num=%d%n", acc, num);

            acc += num;
            return acc;
        });

        int total = opt.getAsInt();
        System.out.println(total);
    }
}
