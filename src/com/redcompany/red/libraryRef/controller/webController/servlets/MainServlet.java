package com.redcompany.red.libraryRef.controller.webController.servlets;

import com.redcompany.red.libraryRef.controller.webController.servlets.util.ConstantsServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        ConstantsServlet.parseRequest(req,resp);
    }


}
