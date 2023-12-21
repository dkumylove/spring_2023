package exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")) {
            //int ch = fis.read();  // 1바이트 읽기 아스키코드로 65 출력
            char ch = (char)fis.read();  // 1바이트 읽기 char(2, 3)- 양의 정수
            System.out.println(ch);

            ch = (char)fis.read();  // 1바이트 읽기
            System.out.println(ch);

            ch = (char)fis.read();  // 1바이트 읽기
            System.out.println(ch);

            ch = (char)fis.read();  // 1바이트 읽기
            System.out.println(ch);

            int ch2 = fis.read();  // 1바이트 읽기  -1 출력( 문자열을 다 읽었음을 알려줌)
            System.out.println(ch2);

            int ch3 = 0;
            while ((ch3 = fis.read()) != -1) {
                System.out.println((char)ch3);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
