package exam03;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private String author;
    private String pubisher;

    public Book() { }

    public Book(String title, String author, String pubisher) {
        this.title = title;
        this.author = author;
        this.pubisher = pubisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pubisher='" + pubisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(pubisher, book.pubisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pubisher);
    }

    @Override
    public int compareTo(Book o) {
        //return o.title.compareTo(title);  // 내림차순
        return title.compareTo(o.title);  // 오름차순

    }

    public String getTitle() {
        return title;
    }
}
