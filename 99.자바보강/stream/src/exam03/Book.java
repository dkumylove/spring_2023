package exam03;

public class Book {
    private String title;
    private String author;
    private String pubisher;

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
}
