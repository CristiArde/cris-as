package towerofhanoi_swing.ui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.Stack;

/*****************************************************************************
 * //TODO Add class/interface description
 *
 * @author Cristi Arde
 * @since 19 May 2020
 ****************************************************************************/
public class ColumnContainer extends JPanel {
    
    private Stack<Ring> ringStack;
    private final BoxLayout BOX_LAYOUT = new BoxLayout(this, BoxLayout.Y_AXIS);
    
    public ColumnContainer(String labelTxt){
        super();
        ringStack = new Stack<>();
        this.setLayout(BOX_LAYOUT);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        Graphics2D g2 = (Graphics2D) g;
        Line2D verticalLine = new Line2D.Float(getPreferredSize().width / 2, 0, getPreferredSize().width / 2,
                                               getPreferredSize().height);
        g2.draw(verticalLine);
    }
    
    public void addRing(Ring ring){
        ring.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(ring,0);
    }
    
    
}
