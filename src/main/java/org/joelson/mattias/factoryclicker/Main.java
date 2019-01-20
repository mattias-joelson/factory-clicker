package org.joelson.mattias.factoryclicker;

import org.joelson.mattias.factoryclicker.ui.FCFrame;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Main::createAndShowUI);
    }
    
    private static void createAndShowUI() {
        JFrame frame = new FCFrame();
        frame.pack();
        frame.setVisible(true);
    }
}