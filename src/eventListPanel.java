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
    JPanel eventControl;
    JPanel display;
    JPanel fullLayoutPanel;
    int ci; // index of the last added event

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
        addEvent.addActionListener(addEventListener);
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

    JPanel modalPanel;
    JComboBox<String> typeSelect;
    JLabel whatType;
    void makeModalPanel()
    {
        modalPanel = new JPanel();
        modalPanel.setLayout(new GridLayout(7,2));

        whatType = new JLabel("What type of event");
        typeSelect = new JComboBox<>(new String[] {"meeting", "deadline"});
        typeSelect.addActionListener(new typeSelectListen());

        modalPanel.add(whatType);
        modalPanel.add(typeSelect);

    }
    void continueDeadline(){
        JLabel objName = new JLabel("name of the obj name");
        JTextField objNameinp = new JTextField();

        JLabel startDate = new JLabel("Start date <mm/dd/yyyy>");
        JTextField startDateinp = new JTextField();
        JLabel startTime =  new JLabel("Start time <HH:mm[am/pm]>");
        JTextField startTimeinp = new JTextField();

        modalPanel.add(objName);
        modalPanel.add(objNameinp);
        modalPanel.add(startDate);
        modalPanel.add(startDateinp);
        modalPanel.add(startTime);
        modalPanel.add(startTimeinp);
    }
    void continueMeeting(){
        continueDeadline();
        JLabel endTime =  new JLabel("End time <HH:mm[am/pm]>");
        JTextField endTimeinp = new JTextField();

        JLabel location = new JLabel("meeting Location");
        JTextField locationinp = new JTextField();

        modalPanel.add(endTime);
        modalPanel.add(endTimeinp);
        modalPanel.add(location);
        modalPanel.add(locationinp);

    }
        void createModal()
    {
        JDialog modal = new JDialog();
        modal.setModal(true);
        modal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        modal.setPreferredSize(new Dimension(450, 400));

        makeModalPanel();
        modal.add(modalPanel);

        modal.pack();
        modal.setVisible(true);
  }

    ActionListener addEventListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            createModal();
        }
    };
    ActionListener submitButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
   private class typeSelectListen implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            String selectedType = (String) typeSelect.getSelectedItem();
            modalPanel.removeAll();
            modalPanel.add(whatType);
            modalPanel.add(typeSelect);
            if(selectedType.equals("meeting"))
            {
                continueMeeting();
            }
            else if(selectedType.equals("deadline"))
            {
                continueDeadline();
            }

        }

    };
}
