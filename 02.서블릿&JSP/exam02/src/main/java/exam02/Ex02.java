package exam02;

public class Ex02 {
    public static void main(String[] args) {
        int result = add(10, 20);

        int result2 = add(30, 40);
    }
    // 스택에 메모리 공간을 할당한 후
    // 연산이 끝나고 사라짐
    // 스택메모리 : 임시적으로 사용됨
    // 함수는 스택의 구조로 짜여져 있다.

    // 매개변수(num1, num2)는 아직 변수가 아님
    // 메모리에 할당을 받아야 변수가 된다.
    public static int add(int num1, int num2) {
        int result = num1 + num2;

        return result;
    }
}
