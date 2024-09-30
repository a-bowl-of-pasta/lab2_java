import LOGIC.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class eventListPanel extends JPanel {

    ArrayList<event> listOfEvents;
    JPanel mainPanel;
    JPanel fullLayoutPanel;
    int ci; // index of the last added event
    JButton addEvent;
    modal inputBox;
    // opens a modal (pop up window) that takes the event's input

    eventListPanel()
    {
        listOfEvents = new ArrayList<>();
        listOfEvents.add(new meeting("default1", "09/25/2024 12:55am", "09/25/2024 03:00am", "location 1"));
        listOfEvents.add(new meeting("default2", "09/26/2024 03:05pm", "09/26/2024 04:00pm", "location 2"));
        listOfEvents.add(new deadline("default3", "09/27/2024 12:00am"));

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 5));
        for(int i = 0; i < listOfEvents.size();i++ )
        {
            eventPanel defaults = new eventPanel(listOfEvents.get(i));
            mainPanel.add(defaults.getDisplay());
            ci = i;
        }

    }
    JPanel buttonPanel()
    {
        JPanel buttonPanel = new JPanel();
        addEvent = new JButton("Add a new event");
        addEvent.setPreferredSize(new Dimension(200, 75));
        addEvent.addActionListener
                (e-> {
                    inputBox = new modal(mainPanel, listOfEvents);
                    inputBox.createModal();
                });
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addEvent);

        return buttonPanel;
    }

    Border PanelPadding = BorderFactory.createEmptyBorder(3,3,3,3);
    JPanel getMainPanel()
    {
        fullLayoutPanel = new JPanel();
        fullLayoutPanel.setLayout(new BorderLayout());
        fullLayoutPanel.add(mainPanel, BorderLayout.CENTER);
        fullLayoutPanel.add(buttonPanel(), BorderLayout.SOUTH);
        fullLayoutPanel.setBorder(PanelPadding);
        return fullLayoutPanel;
    }


}
