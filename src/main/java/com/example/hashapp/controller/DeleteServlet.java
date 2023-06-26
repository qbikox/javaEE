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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Inject
    public DatabaseWebService databaseWebService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getParameter("id") != null) {
            Long id = Long.valueOf(req.getParameter("id"));
            databaseWebService.delete(id);
        }
        List<Hash> hashList = databaseWebService.getAll();
        req.setAttribute("hashList", hashList);
        resp.sendRedirect(req.getContextPath() + "/data");
    }

}
