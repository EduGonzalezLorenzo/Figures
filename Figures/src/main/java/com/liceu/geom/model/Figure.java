package com.liceu.geom.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Figure {
    String name;
    int x;
    int y;
    int size;
    String color;
    String shape;
    User user;
    int id;
    String creationDate;

    public Figure(User user, String name, int x, int y, int size, String color, String shape) {
        this.user = user;
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.shape = shape;
        //Se genera la fecha y hora actual y se le asigna al atributo creationDate
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'a las' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis() + 3600000);
        this.creationDate = formatter.format(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}