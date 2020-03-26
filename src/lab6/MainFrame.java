package lab6;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(){
        super("Magda's Window");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        canvas = new DrawingPanel(this);
        //..TODO
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        setLayout(new FlowLayout());
        add(canvas, CENTER);
        add(configPanel, TOP);
        add(controlPanel, 2);
        //invoke the layout manger
        pack();

    }

}
