import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        ArrayList<Task> tasks = new ArrayList<>();
        SaveFile saveFile = new SaveFile("/home/huang/CS2113/duke/data/dukeHistory");
        int tasksId = saveFile.readFile(tasks);
        boolean running = true;
        while(running){
            Scanner input = new Scanner(System.in);
            String message = input.nextLine();

            String[] tokens = message.split(" ", 2); //parse the command and the rest

            if(tokens[0].equals("done")) {
                if (tokens.length == 1) {
                    System.out.println(line + "OOPS! You forgot to put the number of the task \n" + line);
                } else {
                    int idTaskDone = Integer.parseInt(tokens[1]);
                    tasks.get(idTaskDone - 1).isDone = true; //idTaskDone goes from 1 to n, the position in the array goes from 0 to n-1
                    if (idTaskDone > tasksId || idTaskDone <= 0) { // can't finish a task that doesn't exist
                        System.out.println(line + "Sorry, this task doesn't exist \n" + line);
                    } else {
                        System.out.println(line + "Nice! I've marked this task as done : \n" +
                                tasks.get(idTaskDone - 1).toString() + "\n" + line);
                    }
                }

            }
            else if(message.equals("bye")){ //exit
                System.out.println(line + "Bye. Hope to see you again soon ! \n" + line);
                saveFile.writeFile(tasks);
                running = false;
            }
            else if(message.equals("list")){ //listing all tasks
                System.out.print(line + "Here are the tasks in your list \n");
                for(int i = 0; i < tasks.size(); i++){
                    int numbTask = i+1;
                    System.out.println(numbTask + tasks.get(i).toString());
                }
                System.out.print(line);
            }

            else if(tokens[0].equals("delete")) {
                int idTaskDelete = Integer.parseInt(tokens[1]);
                if (idTaskDelete > tasksId || idTaskDelete <= 0) { // can't finish a task that doesn't exist
                    System.out.println(line + "Sorry, this task doesn't exist \n" + line);
                } else {
                    Task task = tasks.remove(idTaskDelete - 1);
                    tasksId--;
                    System.out.println(line + " Noted. I've removed this task: \n" +
                            task.toString() + "\n" + "Now you have " + tasksId + " tasks in the list \n" + line);
                }
            }
            else if(tokens[0].equals("find")){
                if(tokens.length == 1){
                    System.out.println(line + "OOPS! You forgot to write the keyword \n" + line);
                }
                else {
                    System.out.println(line + "\n Here are the matching tasks in your list: \n");
                    int numbTask = 0;
                    for (Task task : tasks) {
                        numbTask++;
                        if (task.description.contains(tokens[1])) {
                            System.out.println(numbTask + "." + task.toString());
                        }
                    }
                    System.out.println(line);
                }
            }
            else {
                try {
                    if (!(tokens[0].equals("todo") || tokens[0].equals("deadline") || tokens[0].equals("event"))) {
                        throw new NoCommandException("\n" + line + "OOPS!!! I'm sorry, but I don't know what that means :-(\n" + line);
                    }
                    else {
                        if (tokens[0].equals("todo")) {
                            String[] todoMessage = message.split("todo");
                            if (todoMessage.length == 0) {
                                    throw new NoTaskException("\n" + line + "OOPS!!! The description of a todo cannot be empty\n" + line);

                            }
                            else {
                                Todo todo = new Todo(todoMessage[1].trim());
                                tasks.add(todo);
                                int numberTask = tasks.size();
                                System.out.println(line + "Got it. I've added this task : \n" + todo.toString() +
                                        "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                tasksId++;
                            }

                        }
                        else if (tokens[0].equals("deadline")) {

                            String[] messageWoDeadline = message.split("deadline");
                            if (messageWoDeadline.length == 0) {
                                throw new NoTaskException("\n"+ line + "OOPS!!! The description of a deadline cannot be empty\n" + line);

                            }
                            else {
                                String[] deadlineMessage = messageWoDeadline[1].split("/by");
                                if (deadlineMessage.length == 1) {
                                    throw new NoDateException("\n"+ line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                }
                                else {
                                    if (deadlineMessage[0].isBlank()) {
                                        throw new NoTaskException("\n"+ line + "OOPS!!! The description of a deadline cannot be empty\n" + line);
                                    }
                                    else if (deadlineMessage[1].isBlank()) {
                                        throw new NoDateException("\n"+ line + "OOPS!!! The date of a deadline cannot be empty\n" + line);
                                    }
                                    else {
                                        LocalDateTime date = null;
                                        try{
                                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH);
                                            date = LocalDateTime.parse(deadlineMessage[1].trim(), formatter);
                                        }catch (Exception e){
                                            System.out.println("\n"+ line +"OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM" + line);
                                        }
                                        if(!(date == null)) {
                                            Deadline deadline = new Deadline(deadlineMessage[0].trim(), date);
                                            tasks.add(deadline);
                                            int numberTask = tasks.size();
                                            System.out.println(line + "Got it. I've added this task : \n" + deadline.toString() +
                                                    "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                            tasksId++;
                                        }
                                    }
                                }

                            }

                        } else if (tokens[0].equals("event")) {
                            String[] messageWoEvent = message.split("event");
                            if (messageWoEvent.length == 0) {
                                throw new NoTaskException("\n" + line + "OOPS!!! The description of a event cannot be empty\n" + line);
                            }
                            else {
                                String[] eventMessage = messageWoEvent[1].split("/at");
                                if (eventMessage.length == 1) {
                                    throw new NoDateException("\n" + line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                }
                                else {
                                    if (eventMessage[0].isBlank()) {
                                        throw new NoTaskException("\n" + line + "OOPS!!! The description of a event cannot be empty\n" + line);
                                    }
                                    else if (eventMessage[1].isBlank()) {
                                        throw new NoDateException("\n" + line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                    }
                                    else {
                                        String[] eventDate = eventMessage[1].split("-");
                                        if(eventDate.length == 1){
                                            throw new NoDateException("\n" + line + "OOPS!!! The date of a event cannot be empty\n" + line);
                                        } else if (eventDate[0].isBlank() || eventDate[1].isBlank()) {
                                            throw new NoDateException("\n" + line + "OOPS!!! One of the two date are empty\n" + line);
                                        }
                                        else {
                                            LocalDateTime date1 = null;
                                            LocalDateTime date2 = null;
                                            try{
                                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH); //the date format must be this one
                                                date1 = LocalDateTime.parse(eventDate[0].trim(), formatter);
                                                date2 = LocalDateTime.parse(eventDate[1].trim(), formatter);
                                            }catch (Exception e){
                                                System.out.println("\n" + line + "OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM - DD/MM/YYYY HHMM or the date doesn't exist" +line);
                                            }
                                            if(!(date1 == null || date2 == null)) {
                                                Event event = new Event(eventMessage[0].trim(), date1, date2);
                                                tasks.add(event);
                                                int numberTask = tasks.size();
                                                System.out.println(line + "Got it. I've added this task : \n" + event.toString() +
                                                        "\nNow you have " + numberTask + " tasks in the list. \n" + line);
                                                tasksId++;
                                            }
                                        }


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

