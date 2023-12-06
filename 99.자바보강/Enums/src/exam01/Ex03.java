package exam01;

public class Ex03 {
    public static void main(String[] args) {
        // BUS도 객체이기 때문에 상속관계에 확인가능
        System.out.println(Transportation.BUS instanceof Transportation);

        // 상수는 하나만 존재해야하기 때문에 Eunm클래스는 객체 생성이 되지 않는다.
        //Transportation trans = new Transportation();

        int totalFare = Transportation.BUS.getTotal(10);
        System.out.println(totalFare);
    }
}
