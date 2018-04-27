import java.awt.*;

public class GameCanvas extends Canvas {
    public GameCanvas() {
    }

    @Override
    public void update(Graphics g) {
        super.update(g);
    }

    @Override
    public void paint(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.RED);
        g.drawRect(10, 10, 100, 100);
    }
}
