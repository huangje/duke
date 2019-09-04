import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

    public Command parse(String cmd) throws NoNumberTaskException, NoKeywordException, NoTaskException, NoDateException, NoCommandException {
        String[] tokens = cmd.split(" ", 2);
        if(tokens[0].equals("done")) {
            if (tokens.length == 1) {
                throw new NoNumberTaskException("OOPS! Your have to put the number of the task n\"");
            } else {
                if(!tokens[1].matches("\\d+")){
                    throw new NoNumberTaskException("OOPS! Your have to put the number of the task n\"");
                }
                else {
                    return new DoneCommand(Integer.parseInt(tokens[1]));
                }
            }

        }
        else if(cmd.equals("bye")){ //exit
            return new ExitCommand();
        }
        else if(cmd.equals("list")){ //listing all tasks
            return new ListCommand();
        }
        else if(tokens[0].equals("delete")) {
            if (tokens.length == 1) {
                throw new NoNumberTaskException("OOPS! Your have to put the number of the task n\"");
            } else {
                if(!tokens[1].matches("\\d+")){
                    throw new NoNumberTaskException("OOPS! Your have to put the number of the task n\"");
                }
                else {
                    return new DeleteCommand(Integer.parseInt(tokens[1]));
                }
            }

        }
        else if(tokens[0].equals("find")){
            if(tokens.length == 1){
                throw new NoKeywordException("OOPS! You forgot to write the keyword \n");
            }
            else {
                return new FindCommand(tokens[1]);
            }
        }

        else if(tokens[0].equals("todo")){
            String[] todoMessage = cmd.split("todo");
            if (todoMessage.length == 0) {
                throw new NoTaskException("OOPS!!! The description of a todo cannot be empty\n");
            }
            else {
                return new TodoCommand(todoMessage[1].trim());
            }
        }
        else if (tokens[0].equals("deadline")) {
            String[] messageWoDeadline = cmd.split("deadline");
            if (messageWoDeadline.length == 0) {
                throw new NoTaskException("OOPS!!! The description of a deadline cannot be empty\n");
            }
            else {
                String[] deadlineMessage = messageWoDeadline[1].split("/by");
                if (deadlineMessage.length == 1) {
                    throw new NoDateException("OOPS!!! The date of a deadline cannot be empty\n");
                }
                else {
                    if (deadlineMessage[0].isBlank()) {
                        throw new NoTaskException("OOPS!!! The description of a deadline cannot be empty\n");
                    }
                    else if (deadlineMessage[1].isBlank()) {
                        throw new NoDateException("OOPS!!! The date of a deadline cannot be empty\n");
                    }
                    else {
                        LocalDateTime date = null;
                        try{
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH);
                            date = LocalDateTime.parse(deadlineMessage[1].trim(), formatter);
                        }catch(Exception e){
                            throw new NoDateException("OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM or the date doesn't exist");
                        }
                        return new DeadlineCommand(deadlineMessage[1].trim(), date);
                    }
                }
            }
        }
        else if (tokens[0].equals("event")) {
            String[] messageWoEvent = cmd.split("event");
            if (messageWoEvent.length == 0) {
                throw new NoTaskException("OOPS!!! The description of a event cannot be empty\n");
            }
            else {
                String[] eventMessage = messageWoEvent[1].split("/at");
                if (eventMessage.length == 1) {
                    throw new NoDateException("OOPS!!! The date of a event cannot be empty\n");
                }
                else {
                    if (eventMessage[0].isBlank()) {
                        throw new NoTaskException("OOPS!!! The description of a event cannot be empty\n");
                    }
                    else if (eventMessage[1].isBlank()) {
                        throw new NoDateException("OOPS!!! The date of a event cannot be empty\n");
                    }
                    else {
                        String[] eventDate = eventMessage[1].split("-");
                        if(eventDate.length == 1){
                            throw new NoDateException("OOPS!!! The date of a event cannot be empty\n");
                        } else if (eventDate[0].isBlank() || eventDate[1].isBlank()) {
                            throw new NoDateException("OOPS!!! One of the two date are empty\n");
                        }
                        else {
                            LocalDateTime date1 = null;
                            LocalDateTime date2 = null;
                            try{
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH); //the date format must be this one
                                date1 = LocalDateTime.parse(eventDate[0].trim(), formatter);
                                date2 = LocalDateTime.parse(eventDate[1].trim(), formatter);
                            }catch(Exception e){
                                throw new NoDateException("OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM - DD/MM/YYYY HHMM or the date doesn't exist");
                            }
                            return new EventCommand(eventMessage[1].trim(), date1, date2);
                            }
                        }
                    }
                }
            }
        else {
            throw new NoCommandException("OOPS!!! I'm sorry, but I don't know what that means :-(\n");
        }
    }
}
