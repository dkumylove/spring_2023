package exam01;

public class Ex03 {
    public static void main(String[] args) {

        Calculator cal = x ->  x * x;

        int result = cal.square(10);
        System.out.println(result);

        /* 6> 변수명도 너무 김/ x 로 변경 가능
        Calculator cal = num ->  num * num;
        */

        /* 5> 매게변수가 하나이면 () 삭제 가능
        Calculator cal = (num) ->  num * num;
        */

        /* 4> {} return  삭제가능
        Calculator cal = (num) -> {
            return num * num;
        };
        */

        /* 3>  int 삭제해도 가능 인터페이스에서 확인가능
        Calculator cal = (int num) -> {
            return num * num;
        };
        */

        /* 2>
        Calculator cal = (int num) {
                return num * num;
        };
        */

        /* 1>
        Calculator cal = new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }
        };
        */
    }
}
