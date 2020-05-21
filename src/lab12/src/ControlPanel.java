import javax.swing.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlPanel extends JPanel {
    String[] swingComponents= {"JLabel", "JButton", "JCheckBox", "JRadioButton", "JToggleButton", "JScrollBar", "JSlider",
            "JProgressBar", "JSeparator", "JTable", "JTree", "JComboBox", "JSpinner", "JList", "JFileChooser", "JColorChooser",
            "JTextField", "JFormattedTextField", "JPasswordField", "JTextArea", "JEditorPane",
            "JTextPane", "JMenuBar", "JMenu", "JPopupMenu", "JMenuItem", "JCheckboxMenuItem", "JRadioButtonMenuItem",
            "JPanel", "JScrollPane", "JSplitPane", "JTabbedPane", "JDesktopPane", "JToolBar",
            "JFrame", "JDialog", "JWindow", "JInternalFrame", "JApplet"};

    String[] compWithoutText = {"JScrollBar", "JSlider", "JProgressBar", "JSeparator", "JTable",
            "JTree", "JComboBox", "JSpinner", "JList", "JFileChooser", "JColorChooser", "JMenuBar", "JPopupMenu",
            "JCheckboxMenuItem", "JPanel", "JScrollPane", "JSplitPane", "JTabbedPane", "JDesktopPane", "JToolBar",
            "JFrame", "JDialog", "JWindow", "JInternalFrame"};

    List<String> stringList = new ArrayList<>();
    final MainFrame frame;
    JComboBox listItems;
    JLabel classNameLabel = new JLabel("Class name");
    JLabel textLabel = new JLabel("Your text for swing component!");
    JTextField jTextField = new JTextField(20);
    JButton createButton = new JButton("Create and add component");

    public ControlPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        add(classNameLabel);
        listItems= new JComboBox(swingComponents);
        add(listItems);
        add(textLabel);
        add(jTextField);
        add(createButton);
        createButton.addActionListener(this::load);
    }

    private void load(ActionEvent e) {
        stringList = Arrays.asList(compWithoutText);
        String itemText = listItems.getSelectedItem().toString();
        JComponent comp = createDynamicComponent(itemText); //className
        if (!stringList.contains(itemText))
        {
            setComponentText(comp, jTextField.getText());
        }
        frame.designPanel.addAtAbsolutePosition(comp);
    }


    private JComponent createDynamicComponent(String className){
        JComponent returnComponent = null;
        String finalNameClass = "javax.swing." + className;
        try
        {
            Class clazz = Class.forName(finalNameClass);
            returnComponent = (JComponent) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return returnComponent;
    }

    private void setComponentText(JComponent comp, String text)
    {
        try {
            Method method = comp.getClass().getMethod("setText", text.getClass());
            method.invoke(comp, text);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
