package LOGIC;
import java.time.LocalDateTime;

abstract public class event implements Comparable<event>{


    String eventName;
    LocalDateTime eventTime;

    // === abstract classes ===
    public abstract void setName(String name);  // set event name
    public abstract String getName();
    // === concrete classes ===
    public LocalDateTime getEventTime(){return eventTime; }
    public void setEventTime(LocalDateTime time){eventTime = time; } // set date time
    public void setTime(String converToArray){

        String[] time = toArray(converToArray);
        int year =calcYear(time);
        int month =calcMonth(time);
        int day =calcDay(time);
        int hour =calcHour(time);
        int minute =calcMinute(time);

        LocalDateTime theTime = LocalDateTime.of(year, month, day, hour, minute);
        setEventTime(theTime);

    }
    // === implemented ===  method
    public int compareTo(event e){ return eventTime.compareTo(e.eventTime); }

    //===== create time obj ====
    private String[] toArray(String converToArray){

        String[] theArray = new String[14];

        for(int i =0; i < theArray.length; i++){
            if(converToArray.charAt(i) != '/' && converToArray.charAt(i) != ':' && converToArray.charAt(i) != ' '){
                theArray[i] = ""+converToArray.charAt(i);
                System.out.println(theArray[i]);
            }
        }

        return theArray;
    }
    // ##/##/#### <space> ##:##PM
    // [<#,#,><#,#>,<#,#,#,#>,<#,#>,<#,#>,<p,m>]
    //     M    D       Y       H    M     am/pm

    private int calcMonth(String[] time){
        String theMonth= time[0] + time[1];
        return Integer.parseInt(theMonth);
    }
    private int calcDay(String[] time){
        String theDay= time[2] + time[3];
        return Integer.parseInt(theDay);
    }
    private int calcYear(String[] time){
        String calcYear = time[4] + time[5] + time[6] + time[7];
        return Integer.parseInt(calcYear);
    }
    private int calcHour(String[] time){

        int theHour= Integer.parseInt(time[8] + time[9]);
        String ampm = time[12] + time[13];
        if(ampm.equalsIgnoreCase("pm")){
            return 24 - theHour;
        }

        return theHour;
    }
    private int calcMinute(String[] time){
        String theMinute= time[10] + time[11];
        return Integer.parseInt(theMinute);
    }
}
