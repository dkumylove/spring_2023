package exam04;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
        //HashMap<String, String> members = new HashMap<>();
        // 키 자료형의 Commparable 인터페이스
        // 대안 정렬 기준 java.util.Comparator 인터페이스

        //Comparator<String> com = (a,b) -> a.compareTo(b);
        Comparator<String> com = String :: compareTo;

        TreeMap<String, String> members = new TreeMap<>(Comparator.reverseOrder());
        members.put("user01", "이름1");
        members.put("user02", "이름2");
        members.put("user03", "이름3");

        // 수정
        members.put("user02", "(수정)이름2");
        //삭제
        //members.remove("user02");

        //String name = members.get("user02");
        //System.out.println(name);

        // 순서 쌍을 모두 가져옴
        Set<Map.Entry<String, String>> entries = members.entrySet();

        for(Map.Entry<String, String> entry : entries ){
            System.out.printf("key = %s, value = %s%n", entry.getKey(), entry.getValue());
        }

        Set<String> keys = members.keySet();
        Collection<String> values = members.values();

        System.out.println("keys : " + keys);
        System.out.println("values : " + values);
    }
}
