import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    int W = 800, H = 600;
    Random random;
    public DesignPanel(MainFrame frame){
        this.frame = frame;
        setPreferredSize(new Dimension(W, H));
        setLayout(null);
        random = new Random();
    }

    public void addAtAbsolutePosition(JComponent comp){
        int x = random.nextInt(W-1);
        int y = random.nextInt(H-1);
        int w = comp.getPreferredSize().width;
        int h = comp.getPreferredSize().height;
        comp.setBounds(x, y, w, h);
        comp.setToolTipText(comp.getClass().getName());
        this.add(comp);
        frame.repaint();
    }
}
