package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem(new Apple());   // 1. 형변환의 번거로움

        //Object apple = box.getItem();
        //Apple apple = (Apple)box.getItem();

        Object obj = box.getItem();
        if (obj instanceof Pear) {     // 2. 타입 안정성인 떨어짐
            Pear pear = (Pear) obj;
        }

    }
}
