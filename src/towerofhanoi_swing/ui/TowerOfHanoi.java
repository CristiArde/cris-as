package towerofhanoi_swing.ui;

import javax.swing.*;
import java.awt.*;

/*****************************************************************************
 * //TODO Add class/interface description
 *
 * @author Cristi Arde
 * @since 19 May 2020
 ****************************************************************************/
public class TowerOfHanoi extends JFrame {
    
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1200;
    
    public TowerOfHanoi(){
        super("Tower of Hanoi");
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
