import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel designPanel;
    public MainFrame(){
        super("Magda's Window");
        init();
    }

    private void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        controlPanel = new ControlPanel(this);
        designPanel = new DesignPanel(this);
        add(designPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.NORTH);
        pack();
        repaint();
        show();

    }
}
