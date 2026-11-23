package edu.course.lab04;
import java.util.Objects;

public final class Book {
    private final String isbn;
    private final String title;
    public Book(String isbn, String title){
        if (isbn == null){
            throw new NullPointerException("ISBN  не может быть пустым");
        }
        this.isbn = isbn;
        if (title == null){
            throw new NullPointerException("title не может быть пустым");
        }
        this.title = title;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Book book)){
            return false;
        }
        return Objects.equals(isbn, book.isbn);
    }
    @Override
    public int hashCode(){
        return Objects.hash(isbn);
    }

    @Override
    public String toString(){
        return "Book{isbn='" + isbn + "', title='" + title + "'}";
    }
}
