package exam05;

import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        Integer[] nums =  {10, 3, 5, 33, 19, 25};
        //Arrays.sort(nums);  //Comparable 기본 정렬기준 - 오름차순 int[]
        Arrays.sort(nums, Comparator.reverseOrder());  //Comparator - 내림차순 Integer[]

        System.out.println(Arrays.toString(nums));
    }
}
