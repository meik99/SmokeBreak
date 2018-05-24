package com.rynkbit.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddle extends JPanel implements KeyListener {
    private int playerX = 400;
    private final int WIDTH = 100;
    private final int HEIGHT = 15;
    private int Y = 500;

    @Override
    public Rectangle getBounds() {
        return new Rectangle(playerX, Y, WIDTH, HEIGHT);
    }

    public void paintBase(Graphics g) {
        Y = getParent().getHeight() - 100;

        g.setColor(Color.orange);
        g.fillRect(playerX, Y, 100, 15);
        g.setColor(Color.white);
        g.fillRect(playerX, Y, 80, 15);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'A' ||
                e.getKeyChar() == 'a'){
            playerX -= 10;
        }else if(e.getKeyChar() == 'D' ||
                e.getKeyChar() == 'd'){
            playerX += 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
