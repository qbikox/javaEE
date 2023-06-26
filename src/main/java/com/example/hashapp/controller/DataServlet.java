package com.example.hashapp.controller;

import com.example.hashapp.db.DatabaseWebService;
import com.example.hashapp.model.Hash;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

    @Inject
    public DatabaseWebService databaseWebService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hash> hashList = databaseWebService.getAll();
        req.setAttribute("hashList", hashList);
        req.getRequestDispatcher("data.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String value = req.getParameter("value");
        databaseWebService.save(value);
        List<Hash> hashList = databaseWebService.getAll();
        req.setAttribute("hashList", hashList);
        resp.sendRedirect(req.getRequestURI());
    }
}
