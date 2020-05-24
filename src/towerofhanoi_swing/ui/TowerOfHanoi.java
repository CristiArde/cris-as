package towerofhanoi_swing.ui;

import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;
import towerofhanoi_swing.ui.components.ColumnContainer;
import towerofhanoi_swing.ui.components.Ring;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

/*****************************************************************************
 * //TODO Add class/interface description
 *
 * @author Cristi Arde
 * @since 19 May 2020
 ****************************************************************************/
public class TowerOfHanoi extends JFrame {
    
    private final int WINDOW_WIDTH = 1500;
    private final int WINDOW_HEIGHT = 1200;
    private final int START_RINGS_SIZE = 8;
    private int MAX_RING_WIDTH =  200;
    private int MAX_RING_HEIGHT = 50;
    private final static List<Color> RING_COLORS = Arrays.asList(Color.PINK, Color.MAGENTA, Color.RED);//, Color.BLUE, Color.CYAN, Color.yellow, Color.ORANGE, Color.white);
    
    public TowerOfHanoi() {
        super("Tower of Hanoi");
        this.setLayout(new MigLayout("fillx"));
        initUI();
    }
    
    private void initUI() {
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");
        

      
        
        ColumnContainer startColumn = new ColumnContainer("START");
        ColumnContainer midColumn = new ColumnContainer("MID");
        ColumnContainer endColumn = new ColumnContainer("END");
    
        RING_COLORS.forEach(color -> {
            Ring ring = new Ring(color,  MAX_RING_WIDTH -= MAX_RING_WIDTH*0.2);
            startColumn.setAlignmentY(SwingConstants.CENTER);
            startColumn.setAlignmentX(SwingConstants.CENTER);
            startColumn.addRing(ring);
           
        });
        
        startColumn.setAlignmentX(Component.CENTER_ALIGNMENT);
        midColumn.add(jb2);
        midColumn.add(new JLabel("test"), 0);
        endColumn.add(jb3);
        
        
        this.add(startColumn, new CC());
        this.add(midColumn,  new CC().alignY("bottom"));
        this.add(endColumn, new CC().alignY("bottom"));
    }
}
