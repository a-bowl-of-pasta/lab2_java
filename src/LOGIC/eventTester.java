package LOGIC;
import java.io.IOException;
import java.util.Scanner;

public class eventTester
{
    // ===== instruction methods for testing ====
    private static void deadDescription(){

        System.out.println("create the deadline");
        System.out.println("variables ::");
        System.out.println("- bool completed");
        System.out.println("- String eventName <from event>");
        System.out.println("- eventTime <from event>\n");
    }
    private static void meatDescription(){
        System.out.println("create the meeting");
        System.out.println("variables ::");
        System.out.println("- LocalDateTime endTime");
        System.out.println("- String location");
        System.out.println("- bool completed");
        System.out.println("- int meetLength");
        System.out.println("- String eventName <from event>");
        System.out.println("- eventTime <from event>\n");
    }

    // ====== input taking method ====
    private static String takeInp(String prompt) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.print(prompt);
        String input = in.nextLine();

        if(input.equalsIgnoreCase("kll") ){
            ProcessBuilder theCmd = new ProcessBuilder("^C");
            Process runCmd = theCmd.start();
        }

        return input;
    }

    // ====== constructs deadline obj =====
    private static deadline deadlineTesting(){
        deadDescription();
        // -------- variables
        String time ="";
        String ans ="";
        String name ="";
        String isCompletable;
        deadline tester = new deadline();
        // --------- taking input
        try {

            name = takeInp("name of the deadLIne to be added :: ");
            time = takeInp("time for the start of deadline, enter format exactly\n< ##/##/#### ##:##AM> :: ");
            ans = takeInp("is it completable <y/n> :: ");

        }catch (Exception e)
        { System.out.println("!!!! ERROR TAKING INPUT " + e +"  !!!!!" ); }

        // --------- setting obj with input
        tester.setName(name);
        tester.setTime(time);
        if(ans.equalsIgnoreCase("y")){tester.complete();}
        // ---------return test obj
        return tester;

    }

    // ======= constructs meeting obj =======
    private static meeting meatTesting(){

        meeting meat = new meeting();
        meatDescription();

        // ----- inherited methods
        String name = "";
        String startOfMeeting = "";
        String completAns = "";
        // ----- class methods
        String endOfMeeting = "";
        String location = "";
        String meetingLength = ""; // meeting duration

        try {
            name = takeInp("name of the meeting to be added :: ");
            startOfMeeting = takeInp("time for the start of meeting, enter format exactly\n<##/##/#### ##:##AM> :: ");
            completAns = takeInp("is it completable <y/n> :: ");

            endOfMeeting = takeInp("time for the end of the meeting :: ");
            location = takeInp("location of the meeting to be added :: ");
            meetingLength = takeInp("meetLength of the meeting to be added <optional> :: ");

        }catch (Exception e)
        { System.out.println("!!!! ERROR TAKING INPUT " + e +"  !!!!!" ); }

        meat.setName(name);
        meat.setTime(startOfMeeting);
        if(completAns.equalsIgnoreCase("y")){meat.complete();}
        meat.setEndOfMeeting(endOfMeeting);
        meat.setMeetingLocation(location);
        meat.setDuration(meetingLength);


        return meat;

    }

    // ======== main =======
    public static void main(String [] args){
        System.out.println("!!!!!!!!!!!!");
        System.out.println("You are in the terminal tester");
        System.out.println("create a meeting and deadline");
        System.out.println("<type 'KLL' to terminate program>");
        System.out.println("!!!!!!!!!!!!\n\n");

        deadline deadTest = deadlineTesting();

        System.out.println("\ndeadline.getName :: " + deadTest.getName());
        System.out.println("deadline.getEventTime ::"  + deadTest.getEventTime());
        System.out.println("deadline.isCompletable :: " + deadTest.isComplete() +"\n\n");

        meeting meating = meatTesting();
        // ------- inherited methods
        System.out.println("\nmeeting.getName :: " + meating.getName());
        System.out.println("meeting.getEventTime ::"  + meating.getEventTime());
        System.out.println("meeting.isCompletable :: " + meating.isComplete());
        // ------ class methods
        System.out.println("meeting.getEndTime :: " + meating.getEndTime());
        System.out.println("meeting.getMeetingLocation :: " + meating.getMeetingLocation());
        System.out.println("meeting.getDuration :: " + meating.getDuration() + " mins\n\n");



    }

}

