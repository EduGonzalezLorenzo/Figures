package com.liceu.geom.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/drawVal")
public class DrawValidatorController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Boolean figureDrawn = (Boolean) session.getAttribute("drawStatus");

        if (figureDrawn == null){
            resp.sendRedirect("/draw");
            return;
        }
        String drawMsg;

        if (figureDrawn){
            drawMsg = "Figura creada con exito.";
        } else {
            drawMsg = "Error al crear la figura. Falta información o el nombre ya existe.";
        }
        req.setAttribute("deleteMessage", drawMsg);
        session.setAttribute("drawStatus", null);
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
