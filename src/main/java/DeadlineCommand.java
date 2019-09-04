import java.time.LocalDateTime;
import java.util.ArrayList;

public class DeadlineCommand extends AddCommand {



    public DeadlineCommand(String description, LocalDateTime date){
        this.task = new Deadline(description, date);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException{
        super.execute(tasks, ui, storage);
    }
}
