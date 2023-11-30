package exam02;

import lombok.ToString;

public class Student {
    // 필스선언(변수정의)
    private  int id;    // 학번
    private String name;   // 학생명
    private String subject;   // 과목

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
