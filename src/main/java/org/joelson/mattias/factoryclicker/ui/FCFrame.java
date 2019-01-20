package org.joelson.mattias.factoryclicker.ui;

import org.joelson.mattias.factoryclicker.model.ResourceCounter;

import java.awt.Container;
import java.awt.GridLayout;
import java.time.Duration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FCFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    public FCFrame() {
        super("Factory Clicker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initContent(getContentPane());
    }
    
    private static void initContent(Container pane) {
        pane.setLayout(new GridLayout(2,3));
        ResourceCounter coalMined = new ResourceCounter("Coal", 0);
        pane.add(new JLabel(coalMined.getName()));
        JTextField coal = new JTextField(String.valueOf(coalMined.getCount()), 10);
        coal.setHorizontalAlignment(SwingConstants.RIGHT);
        coal.setEditable(false);
        pane.add(coal);
        pane.add(new CraftButton("Handmine coal", Duration.ofMillis(500), () -> addAndUpdate(coalMined, coal)));
        pane.add(new JButton("Mine coal by hand"));
        pane.add(new JButton("Mine iron by hand"));
        pane.add(new JButton("Mine copper by hand"));
    }
    
    private static void addAndUpdate(ResourceCounter counter, JTextField coal) {
        counter.setCount(counter.getCount() + 1);
        coal.setText(String.valueOf(counter.getCount()));
    }
}
