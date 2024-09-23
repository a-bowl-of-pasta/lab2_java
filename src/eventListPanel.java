import LOGIC.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class eventListPanel extends JPanel {

    ArrayList<event> listOfEvents;
    JPanel eventControl;
    JPanel display;

    JComboBox choseSort;
    // a dropdown that sorts by name || date ||similar qualities in reverse order
    // add listener for this comboBox as using a lambda function.

    JCheckBox displayFilter;
    // filters by whatever is checked
    // - !! Add the listener for the filterDisplay as an anonymous class.

    JButton addEvent;
    // opens a modal (pop up window) that takes the event's input


}
