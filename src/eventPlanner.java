import LOGIC.*;
import java.awt.*;
import javax.swing.*;

public class eventPlanner {
    JFrame mainFrame;
    JPanel mainPanel;
    eventListPanel epanel;
    Dimension ScreenSize;

    // !! add eventList panel
    // !! add a static default event so that something shows up if button doesn't work

    eventPlanner(){
        mainFrame = new JFrame();
        ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setPreferredSize(new Dimension(450, (int)ScreenSize.getHeight() - 100));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        epanel = new eventListPanel();
        mainFrame.add(epanel.getMainPanel());

        mainFrame.pack();
        mainFrame.setVisible(true);
    }



    // ========= my main method =========
    public static void main(String [] args){
        eventPlanner ep = new eventPlanner();

    }
}
