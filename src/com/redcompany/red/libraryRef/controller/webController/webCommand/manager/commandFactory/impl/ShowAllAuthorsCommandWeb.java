package com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl;


import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.service.serviceCommand.factory.impl.ServiceFactoryWebCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_SHOW_AUTHORS;



public class ShowAllAuthorsCommandWeb implements BasicCommandWeb {


    private List<Author> authorList;

    @Override
    public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String show_authors = req.getParameter(REO_PARAM_SHOW_AUTHORS);
        ServiceFactoryWebCommand serviceFactoryWebCommand = ServiceFactoryWebCommand.INSTANCE;
        if(show_authors  != null&& show_authors .equals(REO_PARAM_SHOW_AUTHORS)) {
            authorList =  serviceFactoryWebCommand.defineAction(req);
                for (int i = 0; i < authorList.size(); i++) {
                    resp.getWriter().write(
                            "<body>\n" +
                                    authorList.get(i)+
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
