import LOGIC.deadline;
import LOGIC.meeting;
import LOGIC.event;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modal extends eventListPanel
{
    JPanel modalPanel;
    JComboBox<String> typeSelect;
    JLabel whatType;
    JLabel objName;
    JTextField objNameinp;
    JLabel startDate;
    JTextField startDateinp;
    JLabel startTime;
    JTextField startTimeinp;
    JLabel endTime;
    JTextField endTimeinp;
    JLabel location;
    JTextField locationinp;
    JPanel submitButtonPanel;
    JButton submitButton;
    JDialog modal;
    JPanel mainPanel;
    ArrayList<event> listOfEvents;

    modal(JPanel mainPanelRef, ArrayList<event> listOfEventsRef)
    {
        mainPanel = mainPanelRef;
        listOfEvents = listOfEventsRef;

    }
    void makeModalPanel(String eventType)
    {
        modalPanel.removeAll();

        modalPanel.add(whatType);
        modalPanel.add(typeSelect);
        objName = new JLabel("name of the obj name");
        objNameinp = new JTextField();

        startDate = new JLabel("Start date <mm/dd/yyyy>");
        startDateinp = new JTextField();
        startTime =  new JLabel("Start time <HH:mm[am/pm]>");
        startTimeinp = new JTextField();

        modalPanel.add(objName);
        modalPanel.add(objNameinp);
        modalPanel.add(startDate);
        modalPanel.add(startDateinp);
        modalPanel.add(startTime);
        modalPanel.add(startTimeinp);
        if(eventType.equals("meeting"))
        {
            endTime =  new JLabel("End time <HH:mm[am/pm]>");
            endTimeinp = new JTextField();

            location = new JLabel("meeting Location");
            locationinp = new JTextField();

            modalPanel.add(endTime);
            modalPanel.add(endTimeinp);
            modalPanel.add(location);
            modalPanel.add(locationinp);
        }


        modalPanel.revalidate();
        modalPanel.repaint();

    }

    void createModal()
    {
        modal = new JDialog();
        modal.setModal(true);
        modal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        modal.setPreferredSize(new Dimension(450, 400));
        modal.setLayout(new BorderLayout());

        modalPanel = new JPanel();
        modalPanel.setLayout(new GridLayout(7,2));

        submitButtonPanel = new JPanel();
        submitButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 65));
        submitButton.addActionListener(new submitButtonListener());
        submitButtonPanel.add(submitButton);

        whatType = new JLabel("What type of event");
        typeSelect = new JComboBox<>(new String[] {"deadline", "meeting"});
        typeSelect.addActionListener(typeSelectListener);

        makeModalPanel("");


        modal.add(modalPanel, BorderLayout.CENTER);
        modal.add(submitButtonPanel, BorderLayout.SOUTH);

        modal.pack();
        modal.setVisible(true);
    }


    class submitButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            String selectedType = (String) typeSelect.getSelectedItem();
            String Name = objNameinp.getText();
            String startDateTime = startDateinp.getText() + " " + startTimeinp.getText();


            if(selectedType.equals("meeting"))
            {
                String endDateTime = startDateinp.getText() + " " + endTimeinp.getText();
                String loc = locationinp.getText();
                meeting addedMeeting = new meeting(Name, startDateTime, endDateTime, loc);
                listOfEvents.add(addedMeeting);
                ci++;
                eventPanel nextEvent = new eventPanel(addedMeeting);
                mainPanel.add(nextEvent.getDisplay());
                mainPanel.repaint();
                mainPanel.revalidate();
                modal.dispose();

            }else if(selectedType.equals("deadline"))
            {
                deadline addedDeadline = new deadline(Name, startDateTime);
                listOfEvents.add(addedDeadline);
                ci++;
                eventPanel nextEvent = new eventPanel(addedDeadline);
                mainPanel.add(nextEvent.getDisplay());
                mainPanel.repaint();
                mainPanel.revalidate();
                modal.dispose();
            }
            else
            {
                JDialog errorBox = new JDialog();
                errorBox.setModal(true);
                errorBox.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                JPanel errorPanel = new JPanel();
                errorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel errorMessage =  new JLabel(":: ERROR - values are missing ::");
            }
        }
    };
    ActionListener typeSelectListener = new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            String selectedType = (String) typeSelect.getSelectedItem();
            if (!selectedType.isBlank()) {
                makeModalPanel(selectedType);
            }
        }

    };
}
