package exam02;

public class Box<T extends Fruit> {
    private T item;

    //private static T item2;
    //private  T[] item3= new T[];

    public T getItem(){
        return item;
    }
    
    public void setItem(T item) {
        this.item = item;
    }
    
    public void printItem() {
        // T -> Object, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        // T -> Fruit, 객체를 만드는 시점 -> 투입된 타입으로 형변환
        item.print();
    }


    /**
     * T가 결정된 시점. 실제 컴파일될때 T 부분은 제거됨
     * 컴파일을 하기 위해 타입이 결정 되어야함
     * 컴파일 될떄는 T에서 Object로 바뀌어서 컴파일 됨
     * 객체를 만들때 결정됨
     * 객체가 만들어 질때 정의 되기 떄문에 정적 자원인 static은 사용할 수 없다.
     * 배열도 사용하지 못한다. 배열은 new 연산자를 사용하여 크기를 알고 있을떄 사용할 수 있기 떄문에
     */

}
