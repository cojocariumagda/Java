package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        //add all buttons ..TODO

        //configure listeners for all buttons

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //TODO
    }

    private void save(ActionEvent e)
    {
        try{
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream("D:\\FII\\Git\\FII\\AnII\\Sem2\\PA\\DocLab6\\cat.png"));
        } catch (IOException ex) {System.err.println(ex);}
    }

    private void load(ActionEvent e)
    {

    }

    private void reset(ActionEvent e)
    {

    }

    private void exit(ActionEvent e)
    {

    }
}
