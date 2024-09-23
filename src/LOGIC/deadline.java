package LOGIC;


public class deadline extends event implements completable {
    boolean completed;

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public void complete(){
        completed = true;
    }

    @Override
    public String getEventName(){
        return eventName;
    }

    public int compareTo(event e){
        return this.eventTime.compareTo(e.getEventTime());
    }
}
