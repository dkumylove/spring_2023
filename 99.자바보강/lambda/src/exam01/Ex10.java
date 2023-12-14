package exam01;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Ex10 {
    public static void main(String[] args) {
        //Consumer<String> func1 = s -> System.out.println(s);
        // :: 메소드를 참조한다는 뜻
        Consumer<String> func1 = System.out::println;

        //Function<String, Integer> func2 = s -> s.length();
        Function<String, Integer> func2 =String::length;

        //BiPredicate<String, String> func3 = (s1, s2) -> s1.equals(s2); // 매개변수의 순서가 같아야 참조 가능
        //BiPredicate<String, String> func3 = (s1, s2) -> s2.equals(s1); // 이때는 참조가 불가능하다.
        BiPredicate<String, String> func3 = String::equals;

    }
}
