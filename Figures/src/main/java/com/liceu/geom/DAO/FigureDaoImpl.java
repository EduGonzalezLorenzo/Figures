package com.liceu.geom.DAO;

import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.ArrayList;
import java.util.List;

public class FigureDaoImpl implements FigureDao {
    static List<Figure> figuresList = new ArrayList<>();
    static int currentID = 0;

    @Override
    public void saveFigure(Figure figure) {
        figure.setId(currentID);
        figuresList.add(figure);
        currentID++;
    }

    @Override
    public void deleteFigure(Figure figure) {
        for (int i = 0; i < figuresList.size(); i++) {
            if (figure.getId() == figuresList.get(i).getId()){
                figuresList.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Figure> getAllFigures() {
        return figuresList;
    }

}
