package com.redcompany.red.libraryRef.service.serviceCommand.builder.impl;

import com.redcompany.red.libraryRef.dao.mysql.DBCommand;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.entity.Library;
import com.redcompany.red.libraryRef.service.serviceCommand.builder.BuilderCommand;

import java.util.List;

public enum BuilderCommandToDB implements BuilderCommand {

    INSTANCE;

    private DBCommand dbCommand;
    private Library library;
    private List<Author> authorList;
    private List<Book> bookList;
    private Book book;


    @Override
    public List<Author> geAllDataFromLibrary(DBCommand dbCommand) {
        library = dbCommand.getLibrary();
        return library.getAuthorList();

    }

    @Override
    public List<Author> getAuthorListFromLibrary(DBCommand dbCommand) {
        return authorList = dbCommand.getAuthorList();
    }

    @Override
    public List<Book> getBookListFromLibrary(DBCommand dbCommand) {
        return bookList = dbCommand.getBookList();
    }

    @Override
    public void addNewAuthor(DBCommand dbCommand, String author_name) {
        dbCommand.addNewAuthorInDb(author_name);
    }

    @Override
    public void addNewBook(DBCommand dbCommand, String book_name) {
        dbCommand.addNewBookInDb(book_name);
    }

    @Override
    public void deleteBook(DBCommand dbCommand, String id_book) {
        dbCommand.deleteBookInDb(id_book);
    }

    @Override
    public void editBook(DBCommand dbCommand, String id_book, String book_name) {
        dbCommand.editBookInDb(id_book, book_name);
    }

    @Override
    public Book findBook(DBCommand dbCommand, String book_name) {
        return book = dbCommand.findBookInDb(book_name);
    }




}
