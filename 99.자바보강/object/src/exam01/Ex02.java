package exam01;

public class Ex02 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "학생1", "과목1");
        s1.showInfo();
        // showInfo() : 객체나 데이터의 정보를 출력

        Student s2 = new Student(1001, "학생2", "과목2");
        s2.showInfo();

        Student s3 = s2;
        s3.id = 1002;
        s3.name = "학생3";
        s3.subject = "과목3";
        s3.showInfo();
        s2.showInfo();

        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));

        s1 = null; // 값이 없는 상태
    }
}
