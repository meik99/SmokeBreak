package com.rynkbit.game;

import com.rynkbit.game.scene.MainMenu;
import com.rynkbit.game.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    private final Timer gameTimer;

    private Image offscreenImage;
    private Graphics offscreenGraphics;

    private Scene currentScene;

    public Game() throws HeadlessException {
        this.setLayout(new GridLayout(1, 1));
        this.setBackground(Color.BLACK);

        this.gameTimer = new Timer(10, this);
        this.currentScene = new MainMenu(this);

        add(this.currentScene);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 800, 800);
        this.setVisible(true);

        gameTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentScene.update();
        gameTimer.start();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        offscreenImage = createImage(getWidth(), getHeight());

        offscreenGraphics = offscreenImage.getGraphics();
        offscreenGraphics.setColor(Color.BLACK);
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        currentScene.paint(offscreenGraphics);

        g.drawImage(offscreenImage, 0, 0, null);
    }

    public void changeScene(Scene scene) {
        remove(currentScene);
        add(scene);
        scene.setBounds(getBounds());
        currentScene = scene;
        repaint();
    }
}
