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
        Task[] tasks = new  Task[100];
        int tasksId = 0;
        boolean running = true;
        while(running){
            Scanner input = new Scanner(System.in);
            String message = input.nextLine();
            String[] tokens = message.split(" "); //parse string into done and the number
            if(tokens[0].equals("done")){
                int idTaskDone = Integer.parseInt(tokens[1]);
                tasks[(idTaskDone - 1)].isDone = true;
                System.out.println(line + "Nice! I've marked this task as done : \n" +
                        "[" + tasks[(idTaskDone-1)].getStatusIcon() + "] " + tasks[(idTaskDone - 1)].description + "\n" + line);
            }
            else if(message.equals("bye")){ //exit
                System.out.println(line + "bye. Hope to see you again soon ! \n" + line);
                running = false;
            }
            else if(message.equals("list")){ //listing all tasks
                System.out.print(line);
                for(int i =0; i <tasksId; i++){
                    int numbTask = i+1;
                    System.out.println(numbTask + ". " + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                }
                System.out.print(line);
            }
            else {
                tasks[tasksId] = new Task(message); //echo the task
                tasksId++;
                System.out.println(line + "added :" + message + "\n" +line);
            }
        }
    }
}
