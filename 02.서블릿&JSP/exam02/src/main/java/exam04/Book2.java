package exam04;

import lombok.Builder;
import lombok.ToString;

@Builder  // 기본생성자가 private/ 내부에서 객체 생성 필요
@ToString
public class Book2 {
    private String title;
    private String author;
    private String publisher;
}
