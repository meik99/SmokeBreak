package com.rynkbit.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends JPanel implements KeyListener {

    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    private boolean play = false;
    private int playerX = 400;
    private int ballposX = 120;
    private int ballposY = 400;
    private int ballXdir = -1;
    private int ballYdir = -2;

    public Ball() {
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(ballposX, ballposY, WIDTH, HEIGHT);
    }

    public void update() {
        //direction of ball --> when borders touched
        if(play) { //left or right key pressed
            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX <  0) {
                ballXdir = -ballXdir;
            }
            if(ballposY <  0) {
                changeYDirection();
            }
            if(ballposX + WIDTH > getParent().getWidth()) {
                ballXdir = -ballXdir;
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
}
