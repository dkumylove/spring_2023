package exam04;

public class Ex01 {
    public static void main(String[] args) {
        // 직접 생성 안됨
        //Book b1 = new Book();

        // 내부에 있는 객체를 통해 생성
        Book b1 = Book.builder().title("제목1").author("저자1").publisher("출판사1").build();

        System.out.println(b1);
    }
}
