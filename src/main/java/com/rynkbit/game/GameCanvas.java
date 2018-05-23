package com.rynkbit.game;

import com.rynkbit.game.image.ImageAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameCanvas extends JPanel implements ActionListener{
    private final List<Brick> bricks = new ArrayList<>();
    private final Ball ball;
    private final Paddel paddel;
    private final Timer gameTimer;
    private final Game game;

    private Image offscreenImage;
    private Graphics offscreenGraphics;

    public GameCanvas(Game game) {
        ball = new Ball();
        paddel = new Paddel();
        gameTimer = new Timer(10, this);
        this.game = game;

        add(ball);
        add(paddel);

        setBackground(Color.BLACK);

        game.addKeyListener(ball);
        game.addKeyListener(paddel);
        game.requestFocus();

        gameTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        if(bricks.size() == 0){
            bricks.addAll(new ImageAnalyzer(getBounds()).analyze());
        }

        offscreenImage = createImage(getWidth(), getHeight());

        offscreenGraphics = offscreenImage.getGraphics();
        offscreenGraphics.setColor(Color.BLACK);
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        for (Brick brick :
                bricks) {
            brick.draw(offscreenGraphics);
        }

        ball.paint(offscreenGraphics);
        paddel.paintBase(offscreenGraphics);

        g.drawImage(offscreenImage, 0, 0, null);
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
            if(Arrays.stream(brick.getYBounds())
                    .anyMatch(bound -> bound.intersects(ball.getBounds()))){
                ball.changeYDirection();
            }
            if(Arrays.stream(brick.getXBounds())
                    .anyMatch(bound -> bound.intersects(ball.getBounds()))){
                ball.changeXDirection();
            }
        }

        if(ball.getBounds().intersects(paddel.getBounds())){
            ball.changeYDirection();
        }


        bricks.removeAll(bricksToRemove);
        repaint();
    }
}
