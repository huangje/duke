import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventCommand extends AddCommand {


    public EventCommand(String description, LocalDateTime date1, LocalDateTime date2){
        this.task = new Event(description, date1, date2);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException{
        super.execute(tasks, ui, storage);
    }
}
