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
        SaveFile saveFile = new SaveFile("/home/huang/CS2113/duke/data/dukeHistory");
        int tasksId = saveFile.readFile(tasks);
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
                saveFile.writeFile(tasks, tasksId);
                running = false;
            }
            else if(message.equals("list")){ //listing all tasks
                System.out.print(line + "Here are the tasks in your list \n");
                for(int i =0; i <tasksId; i++){
                    int numbTask = i+1;
                    System.out.println(numbTask + tasks[i].toString());
                }
                System.out.print(line);
            }
            else {
                try {
                    if (!(tokens[0].equals("todo") || tokens[0].equals("deadline") || tokens[0].equals("event"))) {
                        throw new NoCommandException(line + "OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
                    }
                    else {
                        if (tokens[0].equals("todo")) {
                            String[] todoMessage = message.split("todo");
                            if (todoMessage.length == 0) {
                                    throw new NoTaskException(line + "OOPS!!! The description of a todo cannot be empty\n" + line);

                            }
                            else {
                                tasks[tasksId] = new Todo(todoMessage[1].trim());
                                int numberTask = tasksId + 1;
                                System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                        "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                tasksId++;
                            }

                        }
                        else if (tokens[0].equals("deadline")) {

                            String[] messageWoDeadline = message.split("deadline");
                            if (messageWoDeadline.length == 0) {
                                throw new NoTaskException(line + "OOPS!!! The description of a deadline cannot be empty\n" + line);

                            }
                            else {
                                String[] deadlineMessage = messageWoDeadline[1].split("/by");
                                if (deadlineMessage.length == 1) {
                                    throw new NoDateException(line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                }
                                else {
                                    if (deadlineMessage[0].isBlank()) {
                                        throw new NoTaskException(line + "OOPS!!! The description of a deadline cannot be empty\n" + line);
                                    }
                                    else if (deadlineMessage[1].isBlank()) {
                                        throw new NoDateException(line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                    }
                                    else {
                                        tasks[tasksId] = new Deadline(deadlineMessage[0].trim(), deadlineMessage[1].trim());
                                        int numberTask = tasksId + 1;
                                        System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                                "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                        tasksId++;
                                    }
                                }

                            }

                        } else if (tokens[0].equals("event")) {
                            String[] messageWoEvent = message.split("event");
                            if (messageWoEvent.length == 0) {
                                throw new NoTaskException(line + "OOPS!!! The description of a event cannot be empty\n" + line);
                            }
                            else {
                                String[] eventMessage = messageWoEvent[1].split("/at");
                                if (eventMessage.length == 1) {
                                    throw new NoDateException(line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                }
                                else {
                                    if (eventMessage[0].isBlank()) {
                                        throw new NoTaskException(line + "OOPS!!! The description of a event cannot be empty\n" + line);
                                    }
                                    else if (eventMessage[1].isBlank()) {
                                        throw new NoDateException(line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                    }
                                    else {
                                        tasks[tasksId] = new Event(eventMessage[0].trim(), eventMessage[1].trim());
                                        int numberTask = tasksId + 1;
                                        System.out.println(line + "Got it. I've added this task : \n" + tasks[tasksId].toString() +
                                                "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                        tasksId++;
                                    }
                                }

                            }
                        }

                    }
                }catch (NoCommandException e) {
                    System.out.println(e);
                }catch (NoTaskException e) {
                    System.out.println(e);
                }catch (NoDateException e) {
                    System.out.println(e);
                }
            }

        }
    }
}
