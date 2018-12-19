package com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl;

import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.service.serviceCommand.factory.impl.ServiceFactoryWebCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_ACTION;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_SHOW_ALL;


public class ShowAllCommandWeb implements BasicCommandWeb {


    private List<Author> authorList;

    @Override
    public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String show_all = req.getParameter(REO_PARAM_ACTION);
        ServiceFactoryWebCommand serviceFactoryWebCommand = ServiceFactoryWebCommand.INSTANCE;
        if(show_all != null&& show_all.equals(REO_PARAM_SHOW_ALL)) {
            authorList =  serviceFactoryWebCommand.defineAction(req);
            for (int i = 0; i < authorList.size(); i++) {
                resp.getWriter().write(
                        "<body>\n" +
                                authorList.get(i)+
                                "<br>" +
                                authorList.get(i).getBooks() +
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
