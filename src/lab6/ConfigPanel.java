package lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel{
    String[] comboItems = {"Random", "Black"};
    final MainFrame frame;
    JLabel sidesLabel; //we're drawing regular polygons
    JSpinner sidesField; //number of sides
    JComboBox colorCombo; //the color of the shape


    public ConfigPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides: ");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);

        // create the colorCombo, containting the values: Random and Black
        colorCombo = new JComboBox(comboItems);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
}
