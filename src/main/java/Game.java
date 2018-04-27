import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() throws HeadlessException {
        this.setLayout(new GridLayout(1, 1));
        this.add(new GameCanvas());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(0, 0, 400, 400);
        this.setVisible(true);
    }
}
