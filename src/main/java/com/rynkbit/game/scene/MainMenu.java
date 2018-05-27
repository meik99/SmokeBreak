package com.rynkbit.game.scene;

import com.rynkbit.game.Game;
import com.rynkbit.game.element.Button;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends Scene implements MouseListener {
    private static final String TITLE = "Smoke Break";
    private static final float TITLE_SIZE = 8f;
    private static final float TEXT_SIZE = 4f;

    private final Game game;
    private final Button btnStart;
    private final Button btnExit;


    /**
     * Creates a new main menu scene
     * @param game
     */
    public MainMenu(Game game) {
        this.game = game;
        btnStart = new Button("Start", 0, 0, (int) (50 * TEXT_SIZE), 48);
        btnExit = new Button("Exit", 0, 58, (int) (50 * TEXT_SIZE), 48);

        game.addMouseListener(this);
    }

    /**
     * Set buttons to the middle of the screen
     */
    @Override
    public void update() {
        btnStart.setX(getBounds().width / 2 - btnStart.getWidth() / 2);
        btnExit.setX(getBounds().width / 2 - btnExit.getWidth() / 2);

        btnStart.setY(getBounds().height / 2 - btnStart.getHeight() / 2 - 10);
        btnExit.setY(getBounds().height / 2 + btnExit.getHeight() / 2 + 10);
    }

    @Override
    public void paint(Graphics g) {
        Font defaultFont = g.getFont();
        int titleWidth;
        int titleHeight;
        int textHeight;

        g.setFont(defaultFont.deriveFont(defaultFont.getSize() * TITLE_SIZE));

        //Get width and height of the title string
        titleWidth = g.getFontMetrics().stringWidth(TITLE);
        titleHeight = (int) g.getFontMetrics().getStringBounds(TITLE, g).getHeight();

        //Drawing title string to the top-center of the screen
        g.setColor(Color.WHITE);
        g.drawString(TITLE, game.getBounds().width / 2 - titleWidth / 2, titleHeight + 10);

        g.setFont(defaultFont.deriveFont(defaultFont.getSize() * TEXT_SIZE));

        //Calculating height of the btnStart-text string.
        //Calculating height of the btnExit-text string not necessary, they have the same height.
        textHeight = (int) g.getFontMetrics().getStringBounds(btnStart.getText(), g).getHeight();

        btnStart.setHeight(textHeight + 10);
        btnExit.setHeight(textHeight + 10);

        //Drawing buttons and button-text
        g.drawRect(btnStart.getX(), btnStart.getY(), btnStart.getWidth(), btnStart.getHeight());
        g.drawRect(btnExit.getX(), btnExit.getY(), btnExit.getWidth(), btnExit.getHeight());

        g.drawString(btnStart.getText(), btnStart.getX() + 10, btnStart.getY() + 5 + textHeight);
        g.drawString(btnExit.getText(), btnExit.getX() + 10, btnExit.getY() + 5 + textHeight);

        g.setFont(defaultFont);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(btnStart.getBounds().contains(e.getPoint())) {
            game.changeScene(new GameScene(game));
        } else if(btnExit.getBounds().contains(e.getPoint())){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
