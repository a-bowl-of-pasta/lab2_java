package LOGIC;
import java.util.Date;

abstract public class event implements Comparable<event>{


    String eventName;
    Date eventTime;

    abstract String getEventName();
    Date getEventTime(){return eventTime; }
    void SDT(Date time){eventTime = time; } // set date time
    void SEN(String name){eventName = name; } // set event name

    @Override
    public int compareTo(event e){
        return eventTime.compareTo(e.eventTime);
    }
}
