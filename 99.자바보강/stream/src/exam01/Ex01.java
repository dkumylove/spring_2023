package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        String[] words = {"aaa", "aa", "bbb", "ccc", "cc", "abc", "asdf"};
        Arrays.stream(words).distinct().filter(s -> s.length() >=3).forEach(System.out::println);

        List<String> words2 = Arrays.asList("aaa", "aa", "bbb", "ccc", "cc", "abc", "asdf");
        words2.stream().distinct().filter(s -> s.length() >=3).forEach(System.out::println);
    }
}
