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
                if(idTaskDone > tasksId || idTaskDone <= 0){
                    System.out.println(line + "Sorry, this task doesn't exist \n" + line);
                }
                else {
                    tasks[(idTaskDone - 1)].isDone = true;
                    System.out.println(line + "Nice! I've marked this task as done : \n" +
                            "[" + tasks[(idTaskDone - 1)].getStatusIcon() + "] " + tasks[(idTaskDone - 1)].description + "\n" + line);
                }
            }
            else if(message.equals("bye")){ //exit
                System.out.println(line + "Bye. Hope to see you again soon ! \n" + line);
                running = false;
            }
            else if(message.equals("list")){ //listing all tasks
                System.out.print(line + "Here are the tasks in your list \n");
                for(int i =0; i <tasksId; i++){
                    int numbTask = i+1;
                    System.out.println(numbTask + ". " + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                }
                System.out.print(line);
            }
            else {
                if(tokens[0].equals("todo")){
                    String[] todoMessage = message.split("todo");
                    tasks[tasksId] = new Todo(todoMessage[1]);
                }
                else if(tokens[0].equals("deadline")){
                    String[] messageWoDeadline = message.split("deadline");
                    String[] deadlineMessage =  messageWoDeadline[1].split("by");
                    tasks[tasksId] = new Deadline(deadlineMessage[0], deadlineMessage[1]);
                }
                else if(tokens[0].equals("event")){
                    String[] messageWoEvent = message.split("event");
                    String[] eventMessage =  messageWoEvent[1].split("at");
                    tasks[tasksId] = new Event(eventMessage[0], eventMessage[1]);
                }
                int numberTask = tasksId + 1;
                System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                        "\nNow you have " + numberTask + " tasks in the list. \n" +line);
                tasksId++;
            }
        }
    }
}
