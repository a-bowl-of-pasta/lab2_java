import LOGIC.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class eventListPanel extends JPanel {

    ArrayList<event> listOfEvents;
    JPanel mainPanel;
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

    eventListPanel()
    {
        listOfEvents = new ArrayList<>();
        listOfEvents.add(new meeting("default1", "09/25/2024 12:55am", "09/25/2025 03:00am", "location 1"));
        listOfEvents.add(new meeting("default2", "09/26/2024 03:05pm", "09/26/2025 04:00pm", "location 2"));
        listOfEvents.add(new deadline("default3", "09/27/2024 12:00am"));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 5));
        for(int i = 0; i < listOfEvents.size();i++ )
        {
            eventPanel defaults = new eventPanel(listOfEvents.get(i));
            mainPanel.add(defaults.getDisplay());
        }

    }
    JPanel getMainPanel(){return mainPanel;}

}
