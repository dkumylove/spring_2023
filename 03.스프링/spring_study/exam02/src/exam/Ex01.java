package exam;

public class Ex01 {
    public static void main(String[] args) {
        // 생성자 함수(메소드) -객체 생성하는 역할(힙 메모리에 필욯나 자원을 위한 공간 할당)
        C c = new C();
        A a = c;
        B b = c;
    }
}
