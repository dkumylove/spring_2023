package exam05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Ex06_addAll_shuffle_maxmin {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();

        Collections.addAll(strs, "a", "b", "c", "d");

        Collections.shuffle(strs);

        System.out.println("strs : " + strs);

        System.out.println("정렬후 가장 끝 요소 : " + Collections.max((strs)));
        System.out.println("정렬후 가장 앞 요소 : " + Collections.min((strs)));
    }
}
