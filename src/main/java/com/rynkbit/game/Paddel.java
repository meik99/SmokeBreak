package com.rynkbit.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paddel extends JPanel implements KeyListener {
    private int playerX = 400;

    public void paintBase(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(playerX, 400, 100, 15);
        g.setColor(Color.white);
        g.fillRect(playerX, 400, 80, 15);
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
