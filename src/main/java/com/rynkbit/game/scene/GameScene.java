package com.rynkbit.game.scene;

import com.rynkbit.game.Ball;
import com.rynkbit.game.Brick;
import com.rynkbit.game.Game;
import com.rynkbit.game.Paddle;
import com.rynkbit.game.image.ImageAnalyzer;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameScene extends Scene{
    private final List<Brick> bricks = new ArrayList<>();
    private final Ball ball;
    private final Paddle paddle;
    private final Game game;
    private boolean paddleSet;


    public GameScene(Game game) {
        paddle = new Paddle();
        ball = new Ball();
        this.game = game;

        add(ball);
        add(paddle);

        game.addKeyListener(ball);
        game.addKeyListener(paddle);
        game.requestFocus();
    }

    @Override
    public void update() {
        final List<Brick> bricksToRemove = new ArrayList<>();
        ball.update();
        paddle.update();


        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = bricks.get(i);
            if (ball.getBounds().intersects(brick.getBounds())) {
                bricksToRemove.add(brick);
                if (Arrays.stream(brick.getYBounds())
                        .anyMatch(bound -> bound.intersects(ball.getBounds()))) {
                    ball.changeYDirection();
                }
                if (Arrays.stream(brick.getXBounds())
                        .anyMatch(bound -> bound.intersects(ball.getBounds()))) {
                    ball.changeXDirection();
                }
                i = bricks.size();
            }
        }

        if(ball.getBounds().intersects(paddle.getBounds())){
            ball.changeYDirection();
        }

        if(ball.getBounds().y > getBounds().height){
            game.changeScene(new MainMenu(game));
        }

        bricks.removeAll(bricksToRemove);
    }

    @Override
    public void paint(Graphics g) {
        if(bricks.size() == 0){
            bricks.addAll(new ImageAnalyzer(getBounds()).analyze());
        }

        for (Brick brick :
                bricks) {
            brick.draw(g);
        }

        ball.paint(g);
        paddle.paintBase(g);

        if(paddleSet == false){
            paddleSet = true;
            ball.setToPaddle(paddle);
        }
    }
}
