package com.liceu.geom.services;

import com.liceu.geom.DAO.FigureDao;
import com.liceu.geom.DAO.FigureDaoImpl;
import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.List;

public class FigureService {
    FigureDao figureDao = new FigureDaoImpl();

    public Boolean newFigure(User user, String name, int x, int y, int size, String color, String shape) {
        if (name.equals("")){
            name = shape + (int) ((Math.random()) * 100);
            Figure figure = new Figure(user, name, x, y, size, color, shape);
            Boolean success = figureDao.saveFigure(figure);
            while (!success){
                name = shape + (int) ((Math.random()) * 100);
                figure = new Figure(user, name, x, y, size, color, shape);
                success = figureDao.saveFigure(figure);
            }
            return true;
        }
        Figure figure = new Figure(user, name, x, y, size, color, shape);
        return figureDao.saveFigure(figure);
    }

    public List<Figure> getAllFigures() {
        return figureDao.getAllFigures();
    }

    public List<Figure> getUserFigures(User user) {
        return figureDao.getUserFigures(user);
    }

    public Boolean deleteFigure(int figureID){
        return figureDao.deleteFigure(figureID);
    }

    public Figure getFigureByID(int figureID) {
        return figureDao.getFigureByID(figureID);
    }
}
