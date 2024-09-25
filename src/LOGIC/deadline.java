package LOGIC;

public class deadline extends event implements completable {
    boolean completed;

    // ===== inherited methods
    // ----- getters
    public boolean isComplete() {return completed;}
    public String getName(){return eventName;}
    // ------ setters
    public void complete(){completed = true;}
    public void setName(String name){eventName = name;}

    // ===== not inherited ====
    public int compareTo(event e){
        return this.eventTime.compareTo(e.getEventTime());
    }
}
