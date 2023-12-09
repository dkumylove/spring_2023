package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1", "과목1");
        System.out.println("s1 : " + s1);

        Student s2 = new Student(1001, "이름2", "과목2");
        System.out.println("s2 : " + s2);

        Student s3 = s2;
        s3.id = 1002;
        s3.name = "이름3";
        s3.subject = "과목3";
        System.out.println("s2 : " + s2); // 주소값을 공유하기 때문에 같이 변경됨
        System.out.println("s3 : " + s3);

    }
}
