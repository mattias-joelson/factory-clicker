package org.joelson.mattias.factoryclicker.ui;

import org.joelson.mattias.factoryclicker.model.ResourceCounter;

import java.awt.Container;
import java.awt.GridLayout;
import java.time.Duration;
import java.util.Map;
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
        pane.setLayout(new GridLayout(5,3));
        
        ResourceCounter ironMined = new ResourceCounter("Iron", 0);
        pane.add(new JLabel(ironMined.getName()));
        JTextField iron = new JTextField(String.valueOf(ironMined.getCount()), 10);
        iron.setHorizontalAlignment(SwingConstants.RIGHT);
        iron.setEditable(false);
        iron.setEditable(false);
        pane.add(iron);
        pane.add(new CraftButton("Handmine iron", Duration.ofMillis(500), () -> addAndUpdate(ironMined, iron)));

        ResourceCounter copperMined = new ResourceCounter("Copper", 0);
        pane.add(new JLabel(copperMined.getName()));
        JTextField copper = new JTextField(String.valueOf(copperMined.getCount()), 10);
        copper.setHorizontalAlignment(SwingConstants.RIGHT);
        copper.setEditable(false);
        copper.setEditable(false);
        pane.add(copper);
        pane.add(new CraftButton("Handmine copper", Duration.ofMillis(500), () -> addAndUpdate(copperMined, copper)));

        ResourceCounter coalMined = new ResourceCounter("Coal", 0);
        pane.add(new JLabel(coalMined.getName()));
        JTextField coal = new JTextField(String.valueOf(coalMined.getCount()), 10);
        coal.setHorizontalAlignment(SwingConstants.RIGHT);
        coal.setEditable(false);
        coal.setEditable(false);
        pane.add(coal);
        pane.add(new CraftButton("Handmine coal", Duration.ofMillis(500), () -> addAndUpdate(coalMined, coal)));

        ResourceCounter stoneMined = new ResourceCounter("Coal", 0);
        pane.add(new JLabel(stoneMined.getName()));
        JTextField stone = new JTextField(String.valueOf(stoneMined.getCount()), 10);
        stone.setHorizontalAlignment(SwingConstants.RIGHT);
        stone.setEditable(false);
        stone.setEditable(false);
        pane.add(stone);
        pane.add(new CraftButton("Handmine stone", Duration.ofMillis(500), () -> addAndUpdate(stoneMined, stone)));

        ResourceCounter burnerMiningDrillBuilt = new ResourceCounter("Burner Mining Drill", 0);
        pane.add(new JLabel(burnerMiningDrillBuilt.getName()));
        JTextField burnerMiningDrill = new JTextField(String.valueOf(burnerMiningDrillBuilt.getCount()), 10);
        burnerMiningDrill.setHorizontalAlignment(SwingConstants.RIGHT);
        burnerMiningDrill.setEditable(false);
        burnerMiningDrill.setFocusable(false);
        pane.add(burnerMiningDrill);
        pane.add(new CraftButton("Handbuild burner mining drill", Duration.ofMillis(4000), () -> addAndUpdate(burnerMiningDrillBuilt, burnerMiningDrill),
                Map.of(ironMined, 9, stoneMined, 5)));
    }
    
    private static void addAndUpdate(ResourceCounter counter, JTextField field) {
        counter.setCount(counter.getCount() + 1);
        field.setText(String.valueOf(counter.getCount()));
    }
}
