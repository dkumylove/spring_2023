package exam03;

import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] strs = {"aa", "bb", "bbb", "ccc"} ;
        boolean result1 = Arrays.stream(strs).allMatch(s -> s.length() >= 3 );
        System.out.println(result1);

        boolean result2 = Arrays.stream(strs).anyMatch(s -> s.length() >= 3 );
        System.out.println(result2);

        // allMatch() : 조건이 모두 참일떄 = 참
        // anyMatch() : 어떤 것이든 하나라도 참이면 = 참
    }
}
