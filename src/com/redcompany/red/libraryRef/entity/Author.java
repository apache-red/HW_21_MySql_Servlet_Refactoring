package com.redcompany.red.libraryRef.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Author {


    private String responsiblePerson;
    private Date creationData;
    private List<Book> books;

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Date getCreationData() {
        return creationData;
    }

    public void setCreationData(Date creationData) {
        this.creationData = creationData;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBookToCatalog(Book book) {
        books.add(book);
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(responsiblePerson, author.responsiblePerson) &&
                Objects.equals(creationData, author.creationData) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responsiblePerson, creationData, books);
    }

    @Override
    public String toString() {
        return "\n"+"Author{" +
                "responsiblePerson='" + responsiblePerson + '\'' +
                ", creationData=" + creationData + '}';
    }
}
