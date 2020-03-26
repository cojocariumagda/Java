package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static  int W=800, H=600;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame;
        createOffScreenImage();
        init();
    }

    private void createOffScreenImage()
    {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init()
    {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y)
    {
        Random rand = new Random();
        int radius = rand.nextInt(500);//TODO; generate a random number

        int sides = (int)frame.configPanel.sidesField.getValue();//get the value from UI (in ConfigPanel)

        Random randColor = new Random();
        float r = randColor.nextFloat() / 2f;
        float g = randColor.nextFloat() / 2f;
        float b = randColor.nextFloat() / 2f;
        Color color = new Color(r, g, b, 0.5f);//create a transparent random Color

        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this);
    }
}
