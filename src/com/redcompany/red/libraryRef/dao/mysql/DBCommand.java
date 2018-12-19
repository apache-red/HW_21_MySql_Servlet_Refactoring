package com.redcompany.red.libraryRef.dao.mysql;


import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.entity.Library;

import java.util.List;

public interface DBCommand {

    Library getLibrary();
    List<Author> getAuthorList();
    List<Book> getBookList();
    void addNewAuthorInDb(String author_name);
    void addNewBookInDb(String book_name);
    void deleteBookInDb(String id_book);
    void editBookInDb(String id_book,String book_name );
    Book findBookInDb(String book_name );

}
