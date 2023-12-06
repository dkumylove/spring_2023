package exam01;

public class Ex02 {
    public static void main(String[] args) {
        String str = "TAXI";

        // Enum 상수로 만들어짐
        Transportation trans = Enum.valueOf(Transportation.class, str);
        System.out.println(trans);

        Transportation trans2 = Transportation.valueOf(str);
        // 상수의 값은 하나, 상수라면 true나옴
        System.out.println(trans == trans2);


    }
}
