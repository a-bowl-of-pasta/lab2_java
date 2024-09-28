import LOGIC.*;
import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;

public class eventPanel extends JPanel {


    JButton isCompleted; // only if the event is completable
    JPanel display;
    meeting meat = null;
    deadline dead = null;
    Border PanelBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
    Border TextFieldBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

    public eventPanel(event e) {
        display = new JPanel();
        display.setLayout(new BorderLayout());
        if (e instanceof deadline)
        {
            dead = (deadline)e;
            addInfo("deadline", dead.getName(), dead.getEventTime(), dead.isComplete());
        }else if (e instanceof meeting)
        {
            meat = (meeting)e;
            addInfo("meeting", meat.getName(), meat.getMeetingLocation(),
                    meat.getEventTime(), meat.getEndTime(), (meat.getDuration() + " mins"));
        }
    }

    void addInfo(String type, String name, LocalDateTime start, boolean completed)
    {
        JTextField dispType = new JTextField(type);
        dispType.setBorder(TextFieldBorder);
        display.add(dispType, BorderLayout.NORTH);

        String theInformation = "- " + type + "\n- " + name + "\n";
        theInformation +="- " + start + "\n- " + completed + "\n";

        JTextArea dispInf = new JTextArea();
        dispInf.setText(theInformation);
        display.add(dispInf, BorderLayout.CENTER);
        dispInf.setEditable(false);
        dispType.setEditable(false);

    }
    void addInfo(String type, String name,String location, LocalDateTime start, LocalDateTime end, String duration){
        JTextField dispType = new JTextField(type + " event type");
        display.add(dispType, BorderLayout.NORTH);

        String theInformation = "- " + name + "\n- " + location + "\n";
        theInformation +="- " + start + "\n- " + end + "\n- " + duration + "\n";

        JTextArea dispInf = new JTextArea();
        dispInf.setText(theInformation);
        display.add(dispInf, BorderLayout.CENTER);

        dispInf.setEditable(false);
        dispType.setEditable(false);
    }


    JPanel getDisplay(){
        display.setBorder(PanelBorder);
        return display;
    }

    void updateUrgency(){
        // - EventPanel should set its background color according to the Urgency of the Event
        // - red for overdue, yellow for imminent, green for distant.

    }
}
