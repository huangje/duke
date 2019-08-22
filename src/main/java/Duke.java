import java.util.*;

//@@author huangje
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "______________________________________________________________ \n";
        boolean running = true;
        while(running){
            Scanner input = new Scanner(System.in);
            String message = input.nextLine();
            if(message.equals("bye")){
                System.out.println(line + "bye. Hope to see you again soon ! \n" + line);
                running = false;
            }
            else {
                System.out.println(line + message + "\n" +line);
            }
        }
    }
}
