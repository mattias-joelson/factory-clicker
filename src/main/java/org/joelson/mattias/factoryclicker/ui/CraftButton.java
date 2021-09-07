package org.joelson.mattias.factoryclicker.ui;

import org.joelson.mattias.factoryclicker.model.ResourceCounter;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CraftButton extends JButton {
    
    private static final long serialVersionUID = 1L;

    private final Duration duration;
    private final Runnable effect;
    private final Map<ResourceCounter, Integer> resources;
    
    public CraftButton(String text, Duration duration, Runnable effect) {
        this(text, duration, effect, Collections.emptyMap());
    }

    public CraftButton(String text, Duration duration, Runnable effect, Map<ResourceCounter, Integer> resources) {
        this.duration = duration;
        this.effect = effect;
        setAction(createAction(text));
        this.resources = resources;
    }

    private Action createAction(String text) {
        return new AbstractAction(text) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Thread.currentThread() + ": actionPerformed @ " + LocalTime.now());
                handleClick();
            }
        };
    }
    
    private void handleClick() {
        System.out.println(Thread.currentThread() + ": disabled @ " + LocalTime.now());
        setEnabled(false);
        resources.entrySet().stream().forEach(resource -> resource.getKey().setCount(resource.getKey().getCount() - resource.getValue()));
        new Thread(this::waitDuration).start();
    }
    
    private void waitDuration() {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> setEnabled(true));
        System.out.println(Thread.currentThread() + ": enabled @ " + LocalTime.now());
        effect.run();
    }
}
