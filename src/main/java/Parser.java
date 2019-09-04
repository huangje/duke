import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {

    public static Command parse(String cmd) throws NoNumberTaskException, NoKeywordException, NoDescriptionException, NoDateException, NoCommandException {
        String[] tokens = cmd.split(" ", 2);
        if(tokens[0].equals("done")) {
            if (tokens.length == 1) {
                throw new NoNumberTaskException();
            } else {
                if(!tokens[1].matches("\\d+")){
                    throw new NoNumberTaskException();
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
                throw new NoNumberTaskException();
            } else {
                if(!tokens[1].matches("\\d+")){
                    throw new NoNumberTaskException();
                }
                else {
                    return new DeleteCommand(Integer.parseInt(tokens[1]));
                }
            }

        }
        else if(tokens[0].equals("find")){
            if(tokens.length == 1){
                throw new NoKeywordException();
            }
            else {
                return new FindCommand(tokens[1]);
            }
        }

        else if(tokens[0].equals("todo")){
            String[] todoMessage = cmd.split("todo");
            if (todoMessage.length == 0) {
                throw new NoDescriptionException();
            }
            else {
                return new TodoCommand(todoMessage[1].trim());
            }
        }
        else if (tokens[0].equals("deadline")) {
            String[] messageWoDeadline = cmd.split("deadline");
            if (messageWoDeadline.length == 0) {
                throw new NoDescriptionException();
            }
            else {
                String[] deadlineMessage = messageWoDeadline[1].split("/by");
                if (deadlineMessage.length == 1) {
                    throw new NoDateException();
                }
                else {
                    if (deadlineMessage[0].isBlank()) {
                        throw new NoDescriptionException();
                    }
                    else if (deadlineMessage[1].isBlank()) {
                        throw new NoDateException();
                    }
                    else {
                        LocalDateTime date = null;
                        try{
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH);
                            date = LocalDateTime.parse(deadlineMessage[1].trim(), formatter);
                        }catch(Exception e){
                            throw new NoDateException();
                        }
                        return new DeadlineCommand(deadlineMessage[1].trim(), date);
                    }
                }
            }
        }
        else if (tokens[0].equals("event")) {
            String[] messageWoEvent = cmd.split("event");
            if (messageWoEvent.length == 0) {
                throw new NoDescriptionException();
            }
            else {
                String[] eventMessage = messageWoEvent[1].split("/at");
                if (eventMessage.length == 1) {
                    throw new NoDateException();
                }
                else {
                    if (eventMessage[0].isBlank()) {
                        throw new NoDescriptionException();
                    }
                    else if (eventMessage[1].isBlank()) {
                        throw new NoDateException();
                    }
                    else {
                        String[] eventDate = eventMessage[1].split("-");
                        if(eventDate.length == 1){
                            throw new NoDateException();
                        } else if (eventDate[0].isBlank() || eventDate[1].isBlank()) {
                            throw new NoDateException();
                        }
                        else {
                            LocalDateTime date1 = null;
                            LocalDateTime date2 = null;
                            try{
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy kkmm", Locale.ENGLISH); //the date format must be this one
                                date1 = LocalDateTime.parse(eventDate[0].trim(), formatter);
                                date2 = LocalDateTime.parse(eventDate[1].trim(), formatter);
                            }catch(Exception e){
                                throw new NoDateException();
                            }
                            return new EventCommand(eventMessage[0].trim(), date1, date2);
                            }
                        }
                    }
                }
            }
        else {
            throw new NoCommandException();
        }
    }
}
