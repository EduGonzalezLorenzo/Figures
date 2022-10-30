package com.liceu.geom.controllers;
import com.liceu.geom.model.Figure;
import com.liceu.geom.services.FigureService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/draw")
public class DrawController extends HttpServlet {
    FigureService figureService = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Figure> figureList = figureService.getAllFigures();
        req.setAttribute("figures", figureList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int x = Integer.parseInt(req.getParameter("xCoor"));
        int y = Integer.parseInt(req.getParameter("yCoor"));
        int size = Integer.parseInt(req.getParameter("size"));
        String shape = req.getParameter("shape");
        String color = req.getParameter("color");

        figureService.newFigure(x, y, size, color, shape);

        resp.sendRedirect("/draw");
    }
}
