package com.rynkbit.game.scene;

import javax.swing.*;
import java.awt.*;

public abstract class Scene extends JPanel {
    public abstract void update();
    public abstract void paint(Graphics g);
}
