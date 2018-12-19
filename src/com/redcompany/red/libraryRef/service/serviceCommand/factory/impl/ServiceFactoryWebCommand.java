package com.redcompany.red.libraryRef.service.serviceCommand.factory.impl;

import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.service.serviceCommand.Director;
import com.redcompany.red.libraryRef.service.serviceCommand.builder.impl.BuilderCommandToDB;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_ACTION;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_AUTHOR_NAME;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//this is model!!
public enum ServiceFactoryWebCommand   {

    INSTANCE;

    Director director = Director.INSTANCE;
    BuilderCommandToDB builderCommandToDB = BuilderCommandToDB.INSTANCE;

    public List defineAction(HttpServletRequest req) {
        switch (req.getParameter(REO_PARAM_ACTION)) {
            case "show_all":
               return director.constructCommandShowAll(builderCommandToDB);
            case "add_author":
               director.constructCommandAddNewAuthor(builderCommandToDB,req.getParameter(REO_PARAM_AUTHOR_NAME));
               break;
            case "show_authors":
                return director.constructCommandShowAuthors(builderCommandToDB);
            case "show_books":
                return director.constructCommandShowBooks(builderCommandToDB);
            case "add_book":
                director.constructCommandAddNewAuthor(builderCommandToDB,req.getParameter(REO_PARAM_AUTHOR_NAME));
                break;

        }
        return null;
    }

}
