package com.rynkbit.game.element;

import java.awt.*;

public class Button {
    private String text;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public void setBounds(int x, int y, int width, int height){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Button(String text, int x, int y, int width, int height) {

        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Button() {

    }
}
