package LOGIC;
import java.time.LocalDateTime;

abstract public class event implements Comparable<event>{


    String eventName;
    LocalDateTime eventTime;

    event(String name, String time){
        eventName = name;
        eventTime = genDateTime(time);
    }
    event()
    {
        eventName = null;
        eventTime = null;
    }
    // === abstract classes ===
    public abstract void setName(String name);  // set event name
    public abstract String getName();
    // === concrete classes ===
    public LocalDateTime getEventTime(){return eventTime; }
    public void setEventTime(LocalDateTime time){eventTime = time; } // set date time
    public void setTime(String converToArray){

        LocalDateTime theTime = genDateTime(converToArray);
        setEventTime(theTime);

    }

    // === implemented ===  method
    public int compareTo(event e){ return eventTime.compareTo(e.eventTime); }

    //===== custom LocalDateTime parser ====
    /*
        I know the LocalDateTime.parse(string) method exists
        but I made my own because I don't think the one for
        the LocalDateTime class accounts for AM/PM, this one does
     */
    public LocalDateTime genDateTime(String cta){
        String [] datingParts = cta.split(" "); // [" ##/##/### "] , [" ##:##AM "]
        int[]theDates = dateToInt(datingParts[0]);
        int[] theHour = hourToInt(datingParts[1]);

        return LocalDateTime.of(theDates[2], theDates[0], theDates[1], theHour[0], theHour[1]);
    }
    // == calculate mm / dd / yy ==
    private int[] dateToInt(String dateParts){

        String [] date = dateParts.split("/");

        int[] toInt = new int[3];
        int j = 0;

        for(String i : date){
            toInt[j] = Integer.parseInt(i);
            j++;
        }

        return toInt;
    }
    // == calculate HH:MM ==
    private int[] hourToInt(String hourParts){

        String [] hour = hourParts.split(":");
        String amInThePm = hour[1].substring(hour[1].length()-2, hour[1].length());
        hour[1] = hour[1].substring(0,hour[1].length() - 2);

        int[] hourAndMin = new int[2];
        int theHour = Integer.parseInt(hour[0]);

        if(amInThePm.equalsIgnoreCase("pm")){
            // ----- if it is 12pm the hour is 12
            // ----- if it is later than 12 it is 12 + hour
            if(theHour == 12){
                hourAndMin[0] = 12;
            }else {
                hourAndMin[0] = 12 + theHour;
            }

        }else {
            // ------ if it is 12am the hour is 0
            // ------ if it is later than 12am it is the hour itself
            if(theHour == 12){
                hourAndMin[0] = 0;
            }else {
                hourAndMin[0] = theHour;
            }
        }
        hourAndMin[1] = Integer.parseInt(hour[1]);

        return hourAndMin;
    }

}
