package com.laraconchego.servlet;

import com.laraconchego.dao.LarDao;
import com.laraconchego.model.Lar;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-lar")
public class CreateLarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String larId = req.getParameter("id");
        String larName = req.getParameter("lar-name");

        LarDao larDao = new LarDao();
        Lar lar = new Lar(larId, larName);

        if (larId.isBlank()) {

            larDao.createLar(lar);

        } else {

            larDao.updateLar(lar);
        }


        resp.sendRedirect("/find-all-cars");

    }

}