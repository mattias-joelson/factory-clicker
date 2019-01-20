package org.joelson.mattias.factoryclicker.ui;

import java.awt.event.ActionEvent;
import java.time.Duration;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;

public class CraftButton extends JButton {
    
    private static final long serialVersionUID = 1L;

    private final Duration duration;
    private final Runnable effect;
    
    public CraftButton(String text, Duration duration, Runnable effect) {
        this.duration = duration;
        this.effect = effect;
        setAction(createAction(text));
    }
    
    private Action createAction(String text) {
        return new AbstractAction(text) {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClick();
            }
        };
    }
    
    private void handleClick() {
        setEnabled(false);
        //System.out.println("disabled @ " + LocalTime.now());
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setEnabled(true);
        //System.out.println("enabled @ " + LocalTime.now());
        effect.run();
    }
    
}
