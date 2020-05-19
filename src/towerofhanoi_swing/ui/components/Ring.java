package towerofhanoi_swing.ui.components;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

/*****************************************************************************
 * //TODO Add class/interface description
 *
 * @author Cristi Arde
 * @since 19 May 2020
 ****************************************************************************/
public class Ring extends JLabel {
    private final int BORDER_THICKNESS = 5;
    private final int RING_RADIUS = 160;
 
    public Ring(Color color){
        super();
        this.setBackground(color);
        this.setOpaque(true);
        this.setPreferredSize(new Dimension(300,100));
        this.setBorder(new TextBubbleBorder(BORDER_THICKNESS,RING_RADIUS));
    }
}


class TextBubbleBorder extends AbstractBorder {
    private int thickness;
    private int radius;
    private Insets insets;
    private BasicStroke stroke;
    private int strokePad;
    private int pointerPad = 4;
    private boolean left = true;
    RenderingHints hints;
    
    TextBubbleBorder(int thickness, int radius) {
        this.thickness = thickness;
        this.radius = radius;
        
        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;
        
        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        int pad = radius + strokePad;
        int bottomPad = pad + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }
    
    
    
    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }
    
    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }
    
    @Override
    public void paintBorder(
            Component c,
            Graphics g,
            int x, int y,
            int width, int height) {
        
        Graphics2D g2 = (Graphics2D) g;
        
        int bottomLineY = height - thickness;
        
        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(
                0 + strokePad,
                0 + strokePad,
                width - thickness,
                bottomLineY, radius, radius);
        
        Polygon pointer = new Polygon();
        
        if (left) {
            // left point
            pointer.addPoint(
                    strokePad + radius + pointerPad,
                    bottomLineY);
            // right point
            pointer.addPoint(
                    strokePad + radius + pointerPad,
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    strokePad + radius + pointerPad,
                    height - strokePad);
        } else {
            // left point
            pointer.addPoint(
                    width - (strokePad + radius + pointerPad),
                    bottomLineY);
            // right point
            pointer.addPoint(
                    width - (strokePad + radius + pointerPad),
                    bottomLineY);
            // bottom point
            pointer.addPoint(
                    width - (strokePad + radius + pointerPad),
                    height - strokePad);
        }
        
        Area area = new Area(bubble);
        area.add(new Area(pointer));
        
        g2.setRenderingHints(hints);
        
        // Paint the BG color of the parent, everywhere outside the clip
        // of the text bubble.
        Component parent  = c.getParent();
        if (parent!=null) {
            Color bg = parent.getBackground();
            Rectangle rect = new Rectangle(0,0,width, height);
            Area borderRegion = new Area(rect);
            borderRegion.subtract(area);
            g2.setClip(borderRegion);
            g2.setColor(bg);
            g2.fillRect(0, 0, width, height);
            g2.setClip(null);
        }
        
        g2.setColor(Color.BLACK);
        g2.setStroke(stroke);
        g2.draw(area);
    }
}
