package Pr5.Task6789;

public class Book implements Printable {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public void print() {
        System.out.println("Книга: '" + title + "'");
        System.out.println("Автор: " + author);
        System.out.println("Год издания: " + year);
        System.out.println("---------------");
    }

    // Геттеры
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
}
