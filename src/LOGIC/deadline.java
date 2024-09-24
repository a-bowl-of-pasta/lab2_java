package LOGIC;

public class deadline extends event implements completable {
    boolean completed;
    // ===== inherited methods
    public boolean isComplete() {return completed;}
    public void complete(){completed = true;}
    public String getName(){return eventName;}
    public void setName(String name){eventName = name;}

    // ===== not inherited ====
    public int compareTo(event e){
        return this.eventTime.compareTo(e.getEventTime());
    }
}
