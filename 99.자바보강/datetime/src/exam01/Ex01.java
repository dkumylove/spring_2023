package exam01;

import java.util.Calendar;

public class Ex01 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println("cal = " + cal);

        showDate(cal);

        cal.set(Calendar.DAY_OF_MONTH, 10);
        showDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, 100);  // 100일 뒤
        showDate(cal);

        cal.add(Calendar.DAY_OF_MONTH, -100);  // 100일 전
        showDate(cal);

        // add : 년 월 일 다 계산하여 더해줌
    }

    private static void showDate(Calendar cal) {
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);  // 0~11
        int date = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println("============================");
        System.out.printf("year=%d, month=%d, date=%d%n", year, month, date);
    }
}
