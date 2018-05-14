package com.rynkbit.game;

import com.rynkbit.game.image.BlockMock;
import com.rynkbit.game.image.ImageAnalyzer;

import java.awt.*;
import java.util.List;

public class GameCanvas extends Canvas {
    private final List<BlockMock> blocks;

    public GameCanvas() {
        blocks = new ImageAnalyzer().analyze();
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);

        blocks.forEach((block) -> block.render(g));
    }
}
