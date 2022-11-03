package com.liceu.geom.controllers;

import com.liceu.geom.services.FigureService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteFigureController extends HttpServlet {
    FigureService figureService = new FigureService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object IDFigureToDelete =  session.getAttribute("figureToDelete");

        if (IDFigureToDelete == null){
            resp.sendRedirect("/draw");
            return;
        }

        String deleteMsg;

        if (figureService.deleteFigure((int)IDFigureToDelete)){
            deleteMsg = "Figura borrada con exito.";
        } else {
            deleteMsg = "No ha sido posible borrar la figura";
        }
        req.setAttribute("deleteMessage", deleteMsg);

        session.setAttribute("figureToDelete", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/deleteFigure.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int figureID = Integer.parseInt(req.getParameter("fid"));

        HttpSession session = req.getSession();
        session.setAttribute("figureToDelete", figureID);

        resp.sendRedirect("/delete");
    }
}
