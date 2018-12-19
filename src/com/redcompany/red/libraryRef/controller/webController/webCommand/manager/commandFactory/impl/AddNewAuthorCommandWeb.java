package com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.impl;

import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.service.serviceCommand.factory.impl.ServiceFactoryWebCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.redcompany.red.libraryRef.controller.webController.webCommand.util.WebConstants.REO_PARAM_AUTHOR_NAME;

public class AddNewAuthorCommandWeb implements BasicCommandWeb {

    @Override
    public void performAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String author_name = req.getParameter(REO_PARAM_AUTHOR_NAME);
        ServiceFactoryWebCommand serviceFactoryWebCommand = ServiceFactoryWebCommand.INSTANCE;
        if (author_name != null){
            serviceFactoryWebCommand.defineAction(req);
            resp.getWriter().write("<body>\n" +
                    "Author was added" +
                    "<input type=\"button\" value=\"<== Previous page\" onclick=\"history.back()\">\n" +
                    "</body>");
        }
        System.out.println("test");


    }

}
