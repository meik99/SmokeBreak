package com.rynkbit.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends JPanel implements KeyListener {

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
        return new Rectangle(ballposX, ballposY, 32, 32);
    }

    public void update() {
        //direction of ball --> when base touched
        if(play) {
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 15))) {
                ballYdir = -ballYdir;
            }
        }


        //direction of ball --> when borders touched
        if(play) { //left or right key pressed
            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX <  0) {
                ballXdir = -ballXdir;
            }
            if(ballposY <  0) {
                ballYdir = -ballYdir;
            }
            if(ballposX > 670) {
                ballXdir = -ballXdir;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(ballposX, ballposY, 32, 32);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        play = true;

    }

    @Override
    public void keyReleased(KeyEvent arg0) {}

    @Override
    public void keyTyped(KeyEvent arg0) {}

}
