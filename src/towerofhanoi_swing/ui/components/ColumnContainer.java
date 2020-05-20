package towerofhanoi_swing.ui.components;

import javax.swing.*;
import java.util.Stack;

/*****************************************************************************
 * //TODO Add class/interface description
 *
 * @author Cristi Arde
 * @since 19 May 2020
 ****************************************************************************/
public class ColumnContainer extends JPanel {
    
    Stack<Ring> ringStack;
    
    public ColumnContainer(String labelTxt){
        super();
        ringStack = new Stack<>();
    }
    
    
}
