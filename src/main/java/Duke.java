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
        String[] tasks = new  String[100];
        int tasksId = 0;
        boolean running = true;
        while(running){
            Scanner input = new Scanner(System.in);
            String message = input.nextLine();
            if(message.equals("bye")){ //exit
                System.out.println(line + "bye. Hope to see you again soon ! \n" + line);
                running = false;
            }
            else if(message.equals("list")){ //listing all tasks
                System.out.print(line);
                for(int i =0; i <tasksId; i++){
                    int numbTask = i+1;
                    System.out.println(numbTask + ". " + tasks[i]);
                }
                System.out.print(line);
            }
            else {
                tasks[tasksId] = message; //echo the task
                tasksId++;
                System.out.println(line + "added :" + message + "\n" +line);
            }
        }
    }
}
