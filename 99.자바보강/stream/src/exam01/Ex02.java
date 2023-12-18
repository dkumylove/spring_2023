package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex02 {
    public static void main(String[] args) {
        String[] words1 = {"aaa", "aa", "bbb", "ccc", "cc", "abc", "asdf"};
        Arrays.stream(words1)
                .distinct()  //중간연산
                .filter(s -> s.length() >= 3) // 증긴연산
                .forEach(System.out::println); // 최종연산 //(s -> System.out.println(s))

        System.out.println("==================");
        List<String> words2 = Arrays.asList("aaa", "aa", "bbb", "ccc", "cc", "abc", "asdf");
        words2.stream()
                .distinct()
                .filter(s -> s.length() >=3)
                .forEach(System.out::println);

       // Stream<String> str =
    }
}
