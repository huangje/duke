import java.time.LocalDateTime;

public class DeadlineCommand extends AddCommand {



    public DeadlineCommand(String description, LocalDateTime date){
        this.task = new Deadline(description, date);
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        super.execute(tasks, ui, storage);
    }
}
