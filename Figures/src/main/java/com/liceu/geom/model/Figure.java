package com.liceu.geom.model;

public abstract class Figure {
    int id;
    int x;
    int y;

    int size;

    User user;

    public Figure(int id, int x, int y, User user) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
