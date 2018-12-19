package com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl;



import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.service.serviceCommand.factory.impl.ServiceFactoryWebCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_ACTION;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_SHOW_BOOKS;

public class ShowAllBooksCommandWeb implements BasicCommandWeb {


    private List<Book> bookList;

    @Override
    public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String show_books = req.getParameter(REO_PARAM_ACTION);
        ServiceFactoryWebCommand serviceFactoryWebCommand = ServiceFactoryWebCommand.INSTANCE;
        if(show_books  != null&& show_books.equals(REO_PARAM_SHOW_BOOKS)) {
            bookList =  serviceFactoryWebCommand.defineAction(req);
            for (int i = 0; i < bookList.size(); i++) {
                resp.getWriter().write(
                        "<body>\n" +
                                bookList.get(i) +
                                "<br>" +
                                "</body>");
            }
            resp.getWriter().write( "<body>\n" +
                    "<input type=\"button\" value=\"<== Previous page\" onclick=\"history.back()\">\n" +
                    "</body>");
        }
        System.out.println("Error");
    }


}
