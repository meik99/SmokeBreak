package com.rynkbit.game.image;


import com.rynkbit.game.GameObject;

import java.awt.*;

public class BlockMock implements GameObject {
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    public BlockMock(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(x, y, width, height);
    }
}
