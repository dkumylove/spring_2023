package exam01;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Ex05 {
    public static void main(String[] args) {
        String str = null;
        //Optional<String> opt = Optional.of(str); // 값이 null 이면 예외발생
        Optional<String> opt = Optional.ofNullable(str); // null값을 허용한다는 것
        //String str2 = opt.get(); // 값이 없으면 예외 발생
        //String str2 = opt.orElse("기본값"); //
        //System.out.println(str2);

//        String str2 = opt.orElse(null);
//        if (str2 ==null){
//            throw new RuntimeException("값이 없음 예외발생");
//        }
        //String str2 = opt.orElseThrow(); // NoSuchElementException 발생
        String str2 = opt.orElseThrow(() -> new RuntimeException("값이 없음, 예외 발생"));
        System.out.println(str2);

//        of() : 인자로서 null값을 받지 않는다
//        ofNullable() : null값을 허용한다는 것
//        orElse() : null이면 orElse()안에 있는 내용이 실행/ null이 아니면 원래 값을 출력
//        매개변수에 값을 넘기지만
//        매개변수가 고정값일떄 사용
//        orElseGet() : 람다식으로 넘긴다.
//        매개변수가 메소드일때 사용하는 것이 좋다
//        orElseThrow() : Optional의 인자가 null일 경우 예외처리를 시킨다.
    }
}
