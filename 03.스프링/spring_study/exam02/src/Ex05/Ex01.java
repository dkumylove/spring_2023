package Ex05;

public class Ex01 {
    public static void main(String[] args) {
        SimpleCalculator cal = new SimpleCalculator();
        int result = cal.add(10,20);
        System.out.println(result);

        // 정적 상수이기 때문에 변경 안됨
        //Calculator.num = 20;

        int result2 = cal.minus(20,10);
        System.out.println(result2);
    }
}
