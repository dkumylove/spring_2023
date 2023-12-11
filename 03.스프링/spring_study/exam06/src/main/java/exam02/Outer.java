package exam02;

public class Outer {
    Calculator method(int num3){
        return  new Calculator() { // 익명 내부 클래스
            public int add(int num1, int num2) {
                //num3 = 40; 지역변수지만 값을 유지해야 하기떄문에 상수화가 됨
                return num1 + num2 + num3;
                }
            };
        }
//        Calculator cal = new Calculator() {
//            public int add(int num1, int num2) {
//                return num1 + num2;
//            }
//        };

//        int result = cal.add(10, 20);
//        System.out.println(result);

//        return cal;
//    }


    /*
    void method(){
           class Inner{
            void innerMethod() {
                System.out.println("지역 내부 클래스");
            }
        }

        Inner in = new Inner();
        in.innerMethod();

    } */

}
