package com.rynkbit.game.image;

import com.rynkbit.game.Brick;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageAnalyzer {
    private static final int THRESHOLD = 200;

    private final Rectangle bounds;

    public ImageAnalyzer(Rectangle bounds){
        this.bounds = bounds;
    }

    private BufferedImage load(){
        try (InputStream inputStream =
                     getClass().getResourceAsStream("/lung.png")) {
            BufferedImage image = ImageIO.read(inputStream);
            int width = (int) (bounds.width * (2.0/3));
            int height = (int) (bounds.height * (1.0/2));
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = result.createGraphics();

            graphics2D.drawImage(scaledImage, 0, 0, null);
            graphics2D.dispose();

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Brick> analyze(){
        List<Brick> bricks = new ArrayList<>();
        BufferedImage image = load();

        int xOffset = (int) (bounds.width / 2.0 - image.getWidth() / 2.0);

        if (image != null) {
            for(int y = 0; y < image.getHeight() - Brick.BRICK_HEIGHT; y+=Brick.BRICK_HEIGHT){
                for (int x = 0; x < image.getWidth() - Brick.BRICK_WIDTH; x+=Brick.BRICK_WIDTH){
                    if(countBlackPixels(image, y, x) < (Brick.BRICK_WIDTH * Brick.BRICK_HEIGHT) / 2){
                        int tmpX = x / Brick.BRICK_WIDTH;
                        int tmpY = y / Brick.BRICK_HEIGHT;

                        tmpX += tmpX * Brick.BRICK_WIDTH + 10;
                        tmpY += tmpY * Brick.BRICK_HEIGHT + 10;

                        tmpX += xOffset;

                        bricks.add(new Brick(tmpX, tmpY));
                    }
                }
            }
        }

        return bricks;
    }

    private int countBlackPixels(BufferedImage image, int y, int x) {
        int count = 0;
        for(int ys = 0; ys < Brick.BRICK_HEIGHT; ys++){
            for(int xs = 0; xs < Brick.BRICK_WIDTH; xs++){
                if(x+xs < image.getWidth() && y+ys < image.getHeight()){
                    Color color = new Color(
                            image.getRGB(x+xs, y+ys));
                    if((color.getRed() + color.getGreen() + color.getBlue()) / 3 > THRESHOLD){
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

}
