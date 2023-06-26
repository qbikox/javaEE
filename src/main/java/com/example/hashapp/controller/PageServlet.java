package com.example.hashapp.controller;

import com.example.hashapp.db.DatabaseWebService;
import com.example.hashapp.generator.HashWebService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/")
@MultipartConfig
public class PageServlet extends HttpServlet {

    @Inject
    public HashWebService hashWebService;

    @Inject
    public DatabaseWebService databaseWebService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("retrievedHash", "");
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Part filePart = req.getPart("file");
            int length = Integer.parseInt(req.getParameter("length"));
            boolean saving = req.getParameter("saving") != null;

            if (filePart != null) {
                InputStream inputStream = filePart.getInputStream();
                byte[] fileBytes = inputStream.readAllBytes();
                String hash = hashWebService.generateHash(fileBytes, length);
                if (saving && hash != null) databaseWebService.save(hash);
                req.setAttribute("retrievedHash", hash != null ? hash : "Hash is empty");
            }
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("retrievedHash", e.getMessage());
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
