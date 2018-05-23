package com.rynkbit.game;

import java.awt.*;

public class Brick {
    public static final int BRICK_WIDTH = 54;
    public static final int BRICK_HEIGHT = 18;
    private int brickX;
    private int brickY;

    public int getBrickX() {
        return brickX;
    }

    public void setBrickX(int brickX) {
        this.brickX = brickX;
    }

    public int getBrickY() {
        return brickY;
    }

    public void setBrickY(int brickY) {
        this.brickY = brickY;
    }

    public Brick(int x, int y) {
        brickX = x;
        brickY = y;
    }

    public Rectangle getBounds(){
        return new Rectangle(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT);

//        g.setColor(Color.BLACK);
//        g.drawRect(brickX , brickY, BRICK_WIDTH, BRICK_HEIGHT);
    }
}