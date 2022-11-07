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

@WebServlet("/allFig")
public class AllFiguresController extends HttpServlet {
    FigureService figureService = new FigureService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Se obtiene la lista de figuras y se envia al cliente.
        List<Figure> figureList = figureService.getAllFigures();

        req.setAttribute("figures", figureList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/allFigures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Se filtra la lista de figuras en base al nombre dado por el usuario y se devuelve la nueva lista al cliente
        req.setAttribute("figures", figureService.getFiguresByNames(figureService.getAllFigures(), req.getParameter("nameSearch")));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/allFigures.jsp");
        dispatcher.forward(req, resp);
    }
}