package com.redcompany.red.libraryRef.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private final String libraryName = "MyLibrary";
    private List<Author> authorList;

    private Author author;




    public void addAuthorToLibrary(Author author){
        authorList.add(author);
    }

    public Author getAuthorFromAuthorList(Library library, int authorNumber){
       return library.authorList.get(authorNumber);
    }

    public Author createNewAuthorInLibrary(){
        return this.author = new Author();
    }
    public  List<Author> createNewAuthorList(){
        return authorList = new ArrayList<>();
    }


    public List<Author> getAuthorList() {
        return authorList;
    }

    public Library createNewLibrary() {
        return new Library();
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(libraryName, library.libraryName) &&
                Objects.equals(authorList, library.authorList) &&
                Objects.equals(author, library.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryName, authorList, author);
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryName='" + libraryName + '\'' +
                ", authorList=" + authorList +
                ", author=" + author +
                '}';
    }
}
