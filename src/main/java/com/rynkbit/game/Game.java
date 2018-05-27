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

    /**
     * Creates a game window and starts update cycle
     * @throws HeadlessException
     */
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

    /**
     * Updates current scene and restarts update-cycle-timer
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        currentScene.update();
        gameTimer.start();
        repaint();
    }

    /**
     * Clears screen and draws the current scene to the
     * it.
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        //Create Image the size of the game-window
        offscreenImage = createImage(getWidth(), getHeight());

        //Set graphics to be used to the images graphics object
        offscreenGraphics = offscreenImage.getGraphics();

        //Draws a black background to clears the screen
        offscreenGraphics.setColor(Color.BLACK);
        offscreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        //Calling the current scenes paint method with the images graphics object
        currentScene.paint(offscreenGraphics);

        //Draws the resulting image to the JFrames Graphics object
        g.drawImage(offscreenImage, 0, 0, null);
    }

    /**
     * Changes the current scene to the given one.
     * @param scene New scene to be drawn
     */
    public void changeScene(Scene scene) {
        remove(currentScene);
        add(scene);
        scene.setBounds(getBounds());
        currentScene = scene;
        repaint();
    }
}
