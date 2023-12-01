package exam04;

public class Exo2 {
    public static void main(String[] args) {
        Book2 b2 = Book2.builder().title("책1").author("저자1").publisher("출판사1").build();
        System.out.println(b2);
    }
}