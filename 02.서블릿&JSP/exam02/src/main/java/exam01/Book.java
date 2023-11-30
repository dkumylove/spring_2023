package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor  (access = AccessLevel.PRIVATE)// 기본 생성자(매개변수 X)
//@AllArgsConstructor   // 모든 매개변수를 초기화하는 생성자 패턴
//@RequiredArgsConstructor   // 상수의 필수 인자를 자동으로 쿠가해줌
//@EqualsAndHashCode    // equals, hashcode 메서드 자동 생성
//@Data  //@Getter + @Setter + @ToString + @EqualsAndHashCode
public class Book {
    private String title;

    //@NonNull  //상수는 아니지만 값이 있어야 한다.
    private String author;
    private String publisher;

    @Override
    public String toString() {
        return super.toString();
    }
}
