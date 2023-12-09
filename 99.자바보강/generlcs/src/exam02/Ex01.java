package exam02;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>(); // 객체를 만든 시점에 T에서 형변환이 일어남
        appleBox.setItem(new Apple());
        //appleBox.setItem(new Pear()0);

        //Apple apple = appleBox.getItem();   // 타입의 안정성, 형변환 X

        Box<Pear> pearBox = new Box<>();

    }
}
