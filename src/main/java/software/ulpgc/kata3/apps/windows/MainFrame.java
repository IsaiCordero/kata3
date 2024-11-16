package software.ulpgc.kata3.apps.windows;

import software.ulpgc.kata3.architecture.control.Command;
import software.ulpgc.kata3.architecture.control.ToggleStatisticCommand;
import software.ulpgc.kata3.architecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final JFreeBarchartDisplay display;
    
    public MainFrame() {
        this.setTitle("Kata 3");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(display = statisticPanel());
        this.commands = new HashMap<>();
    }

    private static JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        return panel;
    }

    private JButton toggle() {
        JButton button = new JButton("Toggle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    commands.get("toggle").execute();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return button;
    }

    public void put(String toggle, Command command) {
        commands.put(toggle, command);
    }

    public BarchartDisplay barchartDisplay() {
        return display;
    }
}
