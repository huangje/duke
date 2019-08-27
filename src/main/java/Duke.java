import java.util.*;

//@@author huangje
public class Duke {
    public static void main(String[] args) throws NoCommandException, NoTaskException, NoDateException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String line = "______________________________________________________________ \n";
        Task[] tasks = new  Task[100];
        boolean hasError = false;
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
                if(!(tokens[0].equals("todo") || tokens[0].equals("deadline") || tokens[0].equals("event"))){
                    try{
                        throw new NoCommandException(line + "OOPS!!! I'm sorry, but I don't know what that means :-(\n"+line);
                    }catch(NoCommandException e){
                        System.out.println(e);
                    }
                }
                else {
                    if(tokens[0].equals("todo")){
                        String[] todoMessage = message.split("todo");
                        if(todoMessage.length == 0) {
                            try {
                                throw new NoTaskException(line + "OOPS!!! The description of a todo cannot be empty\n" + line);
                            }catch(NoTaskException e){
                                System.out.println(e) ;
                            }
                        }
                        else {
                            tasks[tasksId] = new Todo(todoMessage[1]);
                            int numberTask = tasksId + 1;
                            System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                    "\nNow you have " + numberTask + " tasks in the list. \n" +line);
                            tasksId++;
                        }

                    }
                    else if(tokens[0].equals("deadline")){

                        String[] messageWoDeadline = message.split("deadline");
                        if(messageWoDeadline.length == 0) {
                            try {
                                throw new NoTaskException(line + "OOPS!!! The description of a deadline cannot be empty\n" + line);
                            }catch(NoTaskException e){
                                System.out.println(e);
                            }
                        }
                        else {
                            String[] deadlineMessage =  messageWoDeadline[1].split("by");
                            if(deadlineMessage.length == 1) {
                                try {
                                    throw new NoDateException(line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                }catch(NoDateException e){
                                    System.out.println(e) ;
                                }
                            }
                            else {
                                if(deadlineMessage[0].isBlank()){
                                    try {
                                        throw new NoTaskException(line + "OOPS!!! The description of a deadline cannot be empty\n" + line);
                                    }catch(NoTaskException e){
                                        System.out.println(e);
                                    }
                                }
                                else if(deadlineMessage[1].isBlank()){
                                    try {
                                        throw new NoTaskException(line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                    }catch(NoTaskException e){
                                        System.out.println(e);
                                    }
                                }
                                else {
                                    tasks[tasksId] = new Deadline(deadlineMessage[0], deadlineMessage[1]);
                                    int numberTask = tasksId + 1;
                                    System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                            "\nNow you have " + numberTask + " tasks in the list. \n" +line);
                                    tasksId++;
                                }
                            }

                        }

                    }
                    else if(tokens[0].equals("event")){
                        String[] messageWoEvent = message.split("event");
                        if(messageWoEvent.length == 0) {
                            try {
                                throw new NoTaskException(line + "OOPS!!! The description of a event cannot be empty\n" + line);
                            }catch(NoTaskException e){
                                System.out.println(e);
                            }
                        }
                        else {

                            String[] eventMessage =  messageWoEvent[1].split("at");
                            if(eventMessage.length == 1) {
                                try {
                                    throw new NoDateException(line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                }catch(NoDateException e){
                                    System.out.println(e) ;
                                }
                            }
                            else {
                                if(eventMessage[0].isBlank()){
                                    try {
                                        throw new NoTaskException(line + "OOPS!!! The description of a event cannot be empty\n" + line);
                                    }catch(NoTaskException e){
                                        System.out.println(e);
                                    }
                                }
                                else if(eventMessage[1].isBlank()){
                                    try {
                                        throw new NoTaskException(line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                    }catch(NoTaskException e){
                                        System.out.println(e);
                                    }
                                }
                                else {
                                    tasks[tasksId] = new Event(eventMessage[0], eventMessage[1]);
                                    int numberTask = tasksId + 1;
                                    System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                            "\nNow you have " + numberTask + " tasks in the list. \n" +line);
                                    tasksId++;
                                }
                            }

                        }
                    }

                }
            }
        }
    }
}
