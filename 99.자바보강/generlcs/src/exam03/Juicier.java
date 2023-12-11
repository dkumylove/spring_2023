package exam03;

import exam02.Fruit;

public class Juicier {

    public static void make(FruitBox<? super Apple> fruitBox) { // Apple, Fruit, Object
        // 이부분을 확인하기 위해 와일드카드가 나옴 ?
        System.out.println(fruitBox.getItems());
    }

    public  static <T extends Fruit> void make2(FruitBox<T>  fruitBox) {
        System.out.println(fruitBox.getItems());
    }
//    public static void make(FruitBox<Pear> perBox) {
//
//    }
}