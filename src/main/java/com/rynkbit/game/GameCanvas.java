package com.rynkbit.game;

import com.rynkbit.game.image.ImageAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends Canvas implements ActionListener{
    private final List<Brick> bricks;
    private final Ball ball;
    private final Paddel paddel;
    private final Timer gameTimer;

    public GameCanvas(Game game) {
        bricks = new ImageAnalyzer().analyze();
        ball = new Ball();
        paddel = new Paddel();
        gameTimer = new Timer(1000 / 60, this);

        this.addKeyListener(ball);
        this.addKeyListener(paddel);
        this.requestFocus();
        gameTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = bufferedImage.getGraphics();

        graphics.setColor(Color.WHITE);

        graphics.clearRect(0, 0, getWidth(), getHeight());

        graphics.setColor(Color.BLACK);
        g.setColor(Color.BLACK);

        for (Brick brick :
                bricks) {
            brick.draw(graphics);
        }
        ball.paint(graphics);
        paddel.paintBase(graphics);

        g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final List<Brick> bricksToRemove = new ArrayList<>();

        ball.update();
        gameTimer.start();


        for (Brick brick :
                bricks) {
            if(ball.getBounds().intersects(brick.getBounds())){
                bricksToRemove.add(brick);
            }
        }

        bricks.removeAll(bricksToRemove);


        repaint();
    }
}
