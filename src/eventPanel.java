import LOGIC.*;
import javax.swing.*;
import java.awt.*;

public class eventPanel extends JPanel {

    event theEvent;
    JButton isCompleted; // only if the event is completable
    eventPanel() {
        // creates the panel and layout

    }

    void addInfo(){
        //  dislays the data of the event
        // - name
        // - duration
        // - time (if applicable)
        // - location (if applicable)
        // - completion status

    }

    void updateUrgency(){
        // - EventPanel should set its background color according to the Urgency of the Event
        // - red for overdue, yellow for imminent, green for distant.

    }
}
