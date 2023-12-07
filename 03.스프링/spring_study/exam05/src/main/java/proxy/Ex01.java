package proxy;

public class Ex01 {
    public static void main(String[] args) {
        // 반복문 방식
        long stime = System.nanoTime();  // 공통기능
        // 핵심기능
        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10L);
        System.out.printf("cal1 : %d%n", result1);

        long etime = System.nanoTime();  //공통기능
        System.out.printf("Imp걸린시간 : %d%n", etime - stime);

        // 재귀(Recursive)방식
        stime = System.nanoTime();  //공통기능
        // 핵심기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10L);
        System.out.printf("cal2 : %d%n", result2);

        etime = System.nanoTime();  //공통기능
        System.out.printf("Rec걸린시간 : %d%n", etime - stime);

    }
}
