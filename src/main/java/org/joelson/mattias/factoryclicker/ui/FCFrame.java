package org.joelson.mattias.factoryclicker.ui;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class FCFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public FCFrame() {
        super("Factory Clicker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initContent(getContentPane());
    }
    
    private static void initContent(Container pane) {
        pane.setLayout(new GridLayout(3,3));
        pane.add(new JLabel("Coal"));
        pane.add(new JLabel("0"));
        pane.add(new JButton("Handmine coal"));
        pane.add(new JButton("Mine coal by hand"));
        pane.add(new JButton("Mine iron by hand"));
        pane.add(new JButton("Mine copper by hand"));
    }
}
