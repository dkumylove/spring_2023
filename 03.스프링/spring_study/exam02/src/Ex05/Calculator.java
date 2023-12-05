package Ex05;

public interface Calculator {
    // 정적 상수(public static final)
    int num = 10;

    // 인터페이스는 public abstract 컴파일때 알아서 포함됨.
    int add(int num1, int num2);

    default int minus(int num1, int num2){
        return num1 - num2;
    }


}
