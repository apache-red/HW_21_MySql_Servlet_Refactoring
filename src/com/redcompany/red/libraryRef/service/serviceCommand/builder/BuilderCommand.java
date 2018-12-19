package com.redcompany.red.libraryRef.service.serviceCommand.builder;


import com.redcompany.red.libraryRef.dao.mysql.DBCommand;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;

import java.util.List;

public interface BuilderCommand {

    List<Author> geAllDataFromLibrary(DBCommand dbCommand);
    List<Author> getAuthorListFromLibrary(DBCommand dbCommand);
    List<Book> getBookListFromLibrary(DBCommand dbCommand);
    void addNewAuthor(DBCommand dbCommand, String author_name);
    void addNewBook(DBCommand dbCommand, String book_name);
    void deleteBook(DBCommand dbCommand, String id_book);
    void editBook(DBCommand dbCommand, String id_book,String book_name);
    Book findBook(DBCommand dbCommand,String book_name);


}
