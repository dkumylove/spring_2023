package exam05;

import java.io.File;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) throws IOException, InterruptedException {
//        File file = new File("C:/app/spring/test1.txt");
//        file.createNewFile();
//        File dir = new File("C:/app/spring/folder");
        File dir = new File("C:/app/spring/folder1/folder2/folder3");
        if (!dir.exists()) { // 파일 또는 디렉토리 존재 유무
            dir.mkdirs();
        }
        File file = new File(dir, "test1.txt");
        //file.createNewFile();
        File file2 = File.createTempFile("tmp_", ".log", new File("C:/app/spring/"));

        Thread.sleep(5000);

        file2.deleteOnExit();
    }
}
