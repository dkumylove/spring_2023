package exam02;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());
        //appleBox.setItem(new Pear()0);

        //Apple apple = appleBox.getItem();   // 타입의 안정성, 형변환 X

        Box<Pear> pearBox = new Box<>();

    }
}
