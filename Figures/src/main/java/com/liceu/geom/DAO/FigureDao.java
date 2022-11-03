package com.liceu.geom.DAO;

import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.List;

public interface FigureDao {
    Boolean saveFigure(Figure figure);

    Boolean deleteFigure(int figureID);

    List<Figure> getAllFigures();

    List<Figure> getUserFigures(User user);

    Figure getFigureByID(int figureID);
}
