package com.liceu.geom.DAO;

import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.List;

public interface FigureDao {
    void saveFigure(Figure figure);
    List<Figure> getAllFigures();

}
