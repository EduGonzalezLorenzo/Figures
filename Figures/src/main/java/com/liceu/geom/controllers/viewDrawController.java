package com.liceu.geom.controllers;

import com.liceu.geom.model.Figure;
import com.liceu.geom.services.FigureService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view")
public class viewDrawController extends HttpServlet {
    FigureService figureService = new FigureService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object IDFigureToDraw =  session.getAttribute("figureToDraw");

        if (IDFigureToDraw == null){
            resp.sendRedirect("/draw");
            return;
        }

        Figure figureToDraw = figureService.getFigureByID((int)IDFigureToDraw);

        req.setAttribute("figureToDraw", figureToDraw);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/drawView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int figureID = Integer.parseInt(req.getParameter("fid"));

        HttpSession session = req.getSession();
        session.setAttribute("figureToDraw", figureID);

        resp.sendRedirect("/view");
    }
}
