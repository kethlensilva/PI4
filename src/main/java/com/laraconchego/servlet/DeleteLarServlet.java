package com.laraconchego.servlet;

import com.laraconchego.dao.LarDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-lar")
public class DeleteLarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String carId = req.getParameter("id");

        String larId = "";
        new LarDao().deleteLarById(larId);

        resp.sendRedirect("/find-all-cars");

    }

}