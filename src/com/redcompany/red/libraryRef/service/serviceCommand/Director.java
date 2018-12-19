package com.redcompany.red.libraryRef.service.serviceCommand;

import com.redcompany.red.libraryRef.dao.mysql.DBCommand;
import com.redcompany.red.libraryRef.dao.mysql.impl.DaoMysqlImpl;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.service.serviceCommand.builder.BuilderCommand;
import com.redcompany.red.libraryRef.service.serviceCommand.builder.impl.BuilderCommandToDB;

import java.util.List;

public enum  Director {

    INSTANCE;


    public  List<Author> constructCommandShowAll(BuilderCommand builderCommand) {
        return builderCommand.geAllDataFromLibrary(DaoMysqlImpl.INSTANCE);
    }

    public  void constructCommandAddNewAuthor(BuilderCommand builderCommand,String author_name) {
        builderCommand.addNewAuthor(DaoMysqlImpl.INSTANCE, author_name);
    }

    public  List<Author> constructCommandShowAuthors(BuilderCommand builderCommand) {
        return builderCommand.getAuthorListFromLibrary(DaoMysqlImpl.INSTANCE);
    }

    public  List<Book> constructCommandShowBooks(BuilderCommand builderCommand) {
        return builderCommand.getBookListFromLibrary(DaoMysqlImpl.INSTANCE);
    }

}
