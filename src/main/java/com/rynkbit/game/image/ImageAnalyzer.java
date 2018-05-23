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
    private static final int BLOCK_WIDTH= 10;
    private static final int BLOCK_HEIGHT= 10;
    public static final int THRESHOLD = 200;

    public ImageAnalyzer(){

    }

    private BufferedImage load(){
        try (InputStream inputStream =
                     getClass().getResourceAsStream("/lung.png")) {
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Brick> analyze(){
        List<Brick> bricks = new ArrayList<>();
        BufferedImage image = load();

        for(int y = 0; y < image.getHeight(); y+=BLOCK_HEIGHT){
            for (int x = 0; x < image.getWidth(); x+=BLOCK_WIDTH){
                if(countBlackPixels(image, y, x) < (BLOCK_WIDTH * BLOCK_HEIGHT) / 2){
                    bricks.add(new Brick(x, y));
                }
            }
        }

        return bricks;
    }

    private int countBlackPixels(BufferedImage image, int y, int x) {
        int count = 0;
        for(int ys = 0; ys < BLOCK_HEIGHT; ys++){
            for(int xs = 0; xs < BLOCK_WIDTH; xs++){
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
