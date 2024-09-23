package LOGIC;

import java.util.Date;

public class meeting extends event implements completable {

    Date endOfMeeting;
    String meetingLocation;
    int lengthOfMeeting;

    Date getEndTime(){return endOfMeeting;}
    String getMeetingLocation(){return meetingLocation;}
    int getDuration(){


        return (eventTime - endOfMeeting);
    }

    void setEndOfMeeting(Date endOfMeeting){
        this.endOfMeeting = endOfMeeting;
    }
    void setMeetingLocation(String meetingLocation){
        this.meetingLocation = meetingLocation;
    }



    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public void complete() {

    }

    @Override
    String getEventName() {
        return "";
    }
}
