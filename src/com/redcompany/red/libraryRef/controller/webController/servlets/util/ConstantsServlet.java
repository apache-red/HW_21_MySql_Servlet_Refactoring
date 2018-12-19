package com.redcompany.red.libraryRef.controller.webController.servlets.util;

import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.BasicCommandWeb;
import com.redcompany.red.libraryRef.controller.webController.webCommand.manager.commandFactory.FactoryCommandWeb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConstantsServlet {


    public static void parseRequest(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        System.out.println("action +" + action);
        System.out.println(req.getHeader("User-Agent"));
        System.out.println(action);
        if (action != null) {
            FactoryCommandWeb factoryCommandWeb =  FactoryCommandWeb.INSTANCE;
            BasicCommandWeb basicCommandWeb = factoryCommandWeb.defineAction(action);
            try {
                basicCommandWeb.performAction(req, resp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
