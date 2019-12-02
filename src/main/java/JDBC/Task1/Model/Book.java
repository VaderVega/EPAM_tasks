package JDBC.Task1.Model;

import lombok.*;


@Getter
@Setter
public class Book {
    private long id;
    private String author;
    private String name;
    private String genre;
    private int volumes;

    public Book(long id, String author, String name, String genre, int volumes) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.volumes = volumes;
    }

    public Book(String author, String name, String genre, int volumes) {
        this.author = author;
        this.name = name;
        this.genre = genre;
        this.volumes = volumes;
    }
}
