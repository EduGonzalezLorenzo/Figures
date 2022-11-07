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
        //Si se intenta acceder directamente sin que este definida una figura a crear se redirige a draw.
        HttpSession session = req.getSession();
        Boolean figureDrawn = (Boolean) session.getAttribute("drawStatus");

        if (figureDrawn == null) {
            resp.sendRedirect("/draw");
            return;
        }
        //Se intenta crear la figura y se notifica al cliente si ha podido.
        String drawMsg;

        if (figureDrawn) {
            drawMsg = "Figura creada con exito.";
        } else {
            drawMsg = "Error al crear la figura. Falta información o el nombre ya existe.";
        }
        req.setAttribute("drawMessage", drawMsg);
        session.setAttribute("drawStatus", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/drawValidation.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/draw.jsp");
        dispatcher.forward(req, resp);
    }
}
