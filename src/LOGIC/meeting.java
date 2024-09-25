package LOGIC;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class meeting extends event implements completable {

    // ==== variables
    LocalDateTime endOfMeeting;
    String meetingLocation;
    boolean completed;
    int lengthOfMeeting;

    // ===== inherited methods =====
    // -------- getters
    public boolean isComplete() {return completed;}
    public String getName(){return eventName;}
    // -------- setters
    public void complete() {completed = true;}
    public void setName(String name) {eventName = name; }

    // ======== not inherited =======
    // --------- getters
    public LocalDateTime getEndTime(){return endOfMeeting;}
    public String getMeetingLocation(){return meetingLocation;}
    public int getDuration(){return lengthOfMeeting; }
    // ------- setters
    public void setEndOfMeeting(LocalDateTime eom){endOfMeeting = eom;}
    public void setEndOfMeeting(String endOfMeet){ endOfMeeting = genDateTime(endOfMeet); }
    public void setMeetingLocation(String Location){meetingLocation = Location;}
    private void setMeetingLength(int duration){lengthOfMeeting = duration; }
    public void setDuration(String howLong)
    {
        if(howLong.isBlank())
        {
            Duration duration = Duration.between(eventTime, endOfMeeting);
            setMeetingLength((int)duration.toMinutes());
        }else{
            setMeetingLength(Integer.parseInt(howLong));
        }
    }

    // ====== constructor =======
    public meeting(String name,String startTime,String endTime, String location)
    {
     eventName = name;
     eventTime = genDateTime(startTime);
     endOfMeeting = genDateTime(endTime);
     meetingLocation = location;
     completed = false;
     setDuration("");
    }
    public meeting(){
        eventName = null;
        eventTime = null;
        endOfMeeting = null;
        meetingLocation = null;
        completed = false;
        lengthOfMeeting = 0;
    }

}
