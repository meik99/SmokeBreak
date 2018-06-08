package com.rynkbit.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends JPanel implements KeyListener {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    private boolean play = false;
    private int ballposX = 120;
    private int ballposY = 400;
    private int ballXdir = -2;
    private int ballYdir = -4;

    public Ball() {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(ballposX, ballposY, WIDTH, HEIGHT);
    }

    public void update() {
        if(play) {
            ballposX += ballXdir;
            ballposY += ballYdir;

            //If ball hits the left side of the games window
            if(ballposX <  0) {
                changeXDirection();
            }
            //If ball hits the right side of the games window
            if(ballposX + WIDTH > getParent().getWidth()) {
                changeXDirection();
            }
            //If ball hits the upper side of the window
            if(ballposY <  0) {
                changeYDirection();
            }
        }
    }

    public void changeYDirection() {
        ballYdir = -ballYdir;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(ballposX, ballposY, WIDTH, HEIGHT);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        play = true;
    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

    public void changeXDirection() {
        ballXdir = -ballXdir;
    }

    public void setToPaddle(Paddle paddle) {
        ballposX = paddle.getX() + paddle.getWidth() / 2 - WIDTH / 2;
        ballposY = paddle.getY() - HEIGHT;
    }
}
