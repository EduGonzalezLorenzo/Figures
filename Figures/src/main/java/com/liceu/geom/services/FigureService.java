package com.liceu.geom.services;

import com.liceu.geom.DAO.FigureDao;
import com.liceu.geom.DAO.FigureDaoImpl;
import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.List;

public class FigureService {
    FigureDao figureDao = new FigureDaoImpl();

    public void newFigure(User user, String name, int x, int y, int size, String color, String shape) {
        Figure figure = new Figure(user, name, x, y, size, color, shape);
        figureDao.saveFigure(figure);

    }

    public List<Figure> getAllFigures() {
        return figureDao.getAllFigures();
    }
}
