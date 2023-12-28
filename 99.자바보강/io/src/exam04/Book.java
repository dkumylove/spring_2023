package exam04;

import java.io.Serializable;

public class Book implements Serializable {
    //Serializable 마커 인터페이스 : 직렬활에 대한 동의

    public static final long serialVersionUID = 1L;

    private String title;

    private String author;

    private String publisher;

    private String str;
    private String str2;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }


    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
