package com.liceu.geom.controllers;

import com.liceu.geom.model.User;
import com.liceu.geom.services.FigureService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/draw")
public class DrawController extends HttpServlet {
    FigureService figureService = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        RequestDispatcher dispatcher;
        if (currentUser == null) {
            resp.sendRedirect("/login");
            return;
        }
        dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        String name = req.getParameter("figName");
        int x = Integer.parseInt(req.getParameter("xCoor"));
        int y = Integer.parseInt(req.getParameter("yCoor"));
        int size = Integer.parseInt(req.getParameter("size"));
        String shape = req.getParameter("shape");
        String color = req.getParameter("color");

        session.setAttribute("drawStatus", figureService.newFigure(currentUser, name, x, y, size, color, shape));

        resp.sendRedirect("/drawVal");
    }
}
