package LOGIC;
import java.io.IOException;
import java.util.Scanner;
public class eventTester{


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
    private static deadline deadlineTesting(){
        System.out.print("create the deadline\nvariables ::\n");
        System.out.println("- bool completed\n- String eventName <from event>\n- eventTime <from event>\n");

        String time ="";
        String ans ="";
        String name ="";
        String isCompletable;
        deadline tester = new deadline();
        try {

           name = takeInp("name of the deadLIne to be added::");
            time = takeInp("time for the start of deadline < ##/##/#### ##:##AM>");
            ans = takeInp("is it completable <y/n> :: ");

        }catch (Exception e){ System.out.println("!!!! ERROR ERROR !!!!!"); }

        tester.setName(name);
        System.out.println("deadline.getName :: " + tester.getName());
        tester.setTime(time);
        System.out.println("deadline.getEventTime ::"  + tester.getEventTime());
        if(ans == "y"){
            tester.complete();
        }
        System.out.println("deadline.isCompletable :: " + tester.isComplete() );
        return tester;

    }
    private static meeting meatTesting(){

        meeting obj = new meeting();
        System.out.print("create the meeting\nvariables ::\n");
        System.out.print("- LocalDateTime endTime\n- String location\n- bool completed\n- int meetLength\n");
        System.out.print("- String eventName <from event>\n- eventTime <from event>");

        return obj;

    }
    public static void main(String [] args){
        System.out.println("You are in the terminal tester\ncreate a meeting and deadline\n<type :: KLL to terminate program>\n\n");
        deadlineTesting();
        meatTesting();

    }

}

