package exam01;

// 람다식을 의도하고 만듬, 추상메서드가 1개만 정의 되어 있는지를 체크
// 함수형 인터페이스 형식에 맞지 않는다면 에러 띄어줌
@FunctionalInterface
public interface Calculator {
    int square(int num);

    //int root(int num);
}
