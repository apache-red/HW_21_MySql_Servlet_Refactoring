package com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory;

import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl.AddNewAuthorCommandWeb;
import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl.ShowAllAuthorsCommandWeb;
import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl.ShowAllCommandWeb;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.*;
public enum FactoryCommandWeb {

    INSTANCE;


    public BasicCommandWeb defineAction(String action) {
        switch (action) {

            case REO_PARAM_SHOW_ALL:
                return new ShowAllCommandWeb();
            case REO_PARAM_ADD_AUTHOR:
                return new AddNewAuthorCommandWeb();
            case REO_PARAM_SHOW_AUTHORS:
                return new ShowAllAuthorsCommandWeb();
//            case "add_author":
//                return new AddNewAuthorCommandWeb();
//            case "delete_book":
//                return new DeleteBookByIdCommand();
//            case "edit_book_title":
//                return new EditTitleBookByIdCommand();
//            case "find_book_title":
//                return new FindBookByTitleCommand();

            default:
                return null;
        }
    }

}
