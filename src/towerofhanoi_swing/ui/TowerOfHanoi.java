package towerofhanoi_swing.ui;

import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;
import towerofhanoi_swing.ui.components.ColumnContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

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
    
    public TowerOfHanoi() {
        super("Tower of Hanoi");
        this.setLayout(new MigLayout("debug"));
        initUI();
    }
    
    private void initUI() {
        setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel columnOne = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                Line2D verticalLine = new Line2D.Float(getPreferredSize().width / 2, 0, getPreferredSize().width / 2,
                                                       getPreferredSize().height);
                g2.draw(verticalLine);
            }
        };
        JPanel columnTwo = new JPanel();
        JPanel columnThree = new JPanel();
        
        BoxLayout boxlayout1 = new BoxLayout(columnOne, BoxLayout.Y_AXIS);
        BoxLayout boxlayout2 = new BoxLayout(columnTwo, BoxLayout.Y_AXIS);
        BoxLayout boxlayout3 = new BoxLayout(columnThree, BoxLayout.Y_AXIS);
        
        columnOne.setLayout(boxlayout1);
        columnTwo.setLayout(boxlayout2);
        columnThree.setLayout(boxlayout3);
        
        JButton jb1 = new JButton("Button 1");
        JButton jb2 = new JButton("Button 2");
        JButton jb3 = new JButton("Button 3");
        
        
        columnOne.add(jb1);
        columnOne.add(new JLabel("1"), 0);
        columnOne.add(new JLabel("2"), 0);
        columnOne.add(new JLabel("3"), 0);
        columnTwo.add(jb2);
        columnThree.add(jb3);
        
        //Ring ring = new Ring(Color.blue);
        
        //ColumnContainer startColumn = new ColumnContainer("START");
        
        
        this.add(columnOne, new CC().alignY("bottom"));
        this.add(columnTwo,  new CC().alignY("bottom"));
        this.add(columnThree, new CC().alignY("bottom"));
    }
}
