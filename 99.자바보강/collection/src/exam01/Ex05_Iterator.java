package exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex05_Iterator {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        // 반복은 한번만 가능
        Iterator<String> iter = names.iterator();

        while (iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }

        // 다시 생성해서 하면 다시 출력 가능
        iter = names.iterator();
        while (iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }

        // 향상된 for문 - 컬랙션, 배열
        /*for(String name : names) {
            System.out.println(name);
        }*/

        // 스트림 남다식
        //names.forEach((System.out::println);
    }
}
