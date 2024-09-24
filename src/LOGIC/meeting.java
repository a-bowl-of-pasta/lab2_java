package LOGIC;

import java.time.LocalDateTime;
import java.time.Duration;

public class meeting extends event implements completable {
    // ==== variables
    LocalDateTime endOfMeeting;
    String meetingLocation;
    boolean completed;
    int lengthOfMeeting;
    // ===== inherited methods =====
    public boolean isComplete() {return completed;}
    public void complete() {completed = true;}
    public void setName(String name) {eventName = name; }
    public String getName(){return eventName;}
    // ======== not inherited =======
    LocalDateTime getEndTime(){return endOfMeeting;}
    String getMeetingLocation(){return meetingLocation;}
    void setEndOfMeeting(LocalDateTime endOfMeeting){this.endOfMeeting = endOfMeeting;}
    void setMeetingLocation(String meetingLocation){this.meetingLocation = meetingLocation;}

    int getDuration()
    {
        Duration duration = Duration.between(eventTime, endOfMeeting);
        return ((int)duration.toMinutes());
    }
    // ====== constructor =======
    meeting(){
        endOfMeeting = null;
        meetingLocation = null;
        completed = false;
        lengthOfMeeting = 0;
    }
}
