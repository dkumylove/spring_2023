package exam01;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        //System.out.println("names : " + names);

        // 삭제하기
        for(int i = 0; i < names.size(); i++){
            names.remove(i);
        }

        // 조회하기
        for(int i = 0; i < names.size(); i++){
            String name = names.get(i);
            System.out.println("name : " + name);
        }

    }

}
