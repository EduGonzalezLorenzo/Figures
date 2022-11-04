package com.liceu.geom.controllers;

import com.liceu.geom.model.Figure;
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
import java.util.List;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {
    FigureService figureService = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
            resp.sendRedirect("/login");
            return;
        }
        List<Figure> figureList = figureService.getUserFigures(currentUser);
        req.setAttribute("figures", figureList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        List<Figure> figureList = figureService.getUserFigures(currentUser);
        req.setAttribute("figures", figureService.getFiguresByNames(figureList, req.getParameter("nameSearch")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
        dispatcher.forward(req, resp);
    }
}