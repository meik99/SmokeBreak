package com.rynkbit.game;


public class Paddle implements GameObject, KeyListener, Action Listener {
    //Ball
    private int ballposX;
    private int ballposY;
    private int ballXdir;
    private int ballYdir;

    private int getBallposX(){
        return posX;
    }

    private int getBallposY(){
        return posY;
    }

    private int getBallXdir() {
        return ballXdir;
    }

    private int getBallYdir(){
        return ballYdir
    }

    //Paddle
    private boolean play = false;
    private int playerX;
    private Timer timer;

    private int getPlayerX(){
        return playerX;
    }

    @Override
    void update(){ }

    @Override
    void render(Graphics graphics){
        //Ball
        graphics.setColor(Color.WHITE);
        graphics.fillOval(getPosX(), getPosY(), 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        timer.starter();
        if (play){

            //Brick
            A: for (int i = 0; i<map.map.length; i++){
                for (int j = 0; j<map.map[0].length; j++){
                    if (map.map[i][j] > 0){
                        int brickX = j*map.brickwidth + 80;
                        int brickY = i*map.brickHeight +50;
                        int brickWidth = map.brickWidth;
                        int brichHeight = map.brickHight;

                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth; brichHeight);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rect;

                        if (ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalBricks --;

                            if (ballposY + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }
            //Hit the Wall
            ballposX += ballXdir;
            ballposY y= ballYdir;
            if (ballposX < 0){
                ballXdir = -ballXdir;
            }
            if (ballposY < 0){
                ballYdir = -ballYdir;
            }
            if (ballposX > 600){
                ballXdir = -ballXdir;
            }
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e){}
    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if (playerX >= 600){
                playerX = 600;
            } else {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (playerX <= 0){
                playerX = 0;
            } else {
                moveLeft();
            }
        }
    }

    public void moveRight(){
        play = true;
        playerX+=20;
    }

    public void moveLeft(){
        play = true;
        playerX-=20;
    }
}
