import LOGIC.*;
import java.awt.*;
import javax.swing.*;

public class eventPlanner {
    JFrame mainFrame;
    JPanel mainPanel;
    eventListPanel epanel;

    // !! add eventList panel
    // !! add a static default event so that something shows up if button doesn't work

    eventPlanner(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        epanel = new eventListPanel();
        mainFrame.add(epanel.getMainPanel());


        mainFrame.setVisible(true);
    }



    // ========= my main method =========
    public static void main(String [] args){
        eventPlanner ep = new eventPlanner();

    }
}
