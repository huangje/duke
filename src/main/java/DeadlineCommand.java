import java.time.LocalDateTime;

/**
 * The deadline command that will add a deadline task
 */
public class DeadlineCommand extends AddCommand {


    /**
     * Constructor
     * @param description the description of a deadline task
     * @param date the date of a deadline task
     */
    public DeadlineCommand(String description, LocalDateTime date){
        this.task = new Deadline(description, date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        super.execute(tasks, ui, storage);
    }
}
