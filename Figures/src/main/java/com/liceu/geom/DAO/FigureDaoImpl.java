package com.liceu.geom.DAO;

import com.liceu.geom.model.Figure;
import com.liceu.geom.model.User;

import java.util.ArrayList;
import java.util.List;

public class FigureDaoImpl implements FigureDao {
    static List<Figure> figuresList = new ArrayList<>();
    static int currentID = 0;

    @Override
    public Boolean saveFigure(Figure figure) {
        for (Figure f : figuresList) {
            if (f.getName().equals(figure.getName()) && f.getUser().getName().equals(figure.getUser().getName())){
                return false;
            }
        }
        figure.setId(currentID);
        figuresList.add(figure);
        currentID++;
        return true;
    }

    @Override
    public Boolean deleteFigure(int figureID) {
        for (int i = 0; i < figuresList.size(); i++) {
            if (figureID == figuresList.get(i).getId()) {
                figuresList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Figure> getAllFigures() {
        return figuresList;
    }

    @Override
    public List<Figure> getUserFigures(User user) {
        List<Figure> userFiguresList = new ArrayList<>();
        for (Figure figure : figuresList) {
            if (figure.getUser().getName().equals(user.getName())) {
                userFiguresList.add(figure);
            }
        }
        return userFiguresList;
    }

    @Override
    public Figure getFigureByID(int figureID) {
        for (Figure figure : figuresList) {
            if (figure.getId() == figureID) {
                return figure;
            }
        }
        return null;
    }

}
