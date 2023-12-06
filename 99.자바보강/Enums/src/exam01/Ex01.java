package exam01;

// 정정자원에는 static을 붙여 import 함
import static exam01.Transportation.*;

public class Ex01 {
    public static void main(String[] args) {
        // 정적 상수
        Transportation bus = BUS;
        System.out.println(BUS == Transportation.BUS);
        System.out.printf("ordinal() : %d, name() : %s%n", bus.ordinal(), bus.name());
    }
}
