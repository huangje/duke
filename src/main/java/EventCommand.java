import java.time.LocalDateTime;

/**
 * the event command that will add a event task
 */
public class EventCommand extends AddCommand {

    /**
     * Constructor
     * @param description the description of an event task
     * @param date1 the start date of an event task
     * @param date2 the end date of an event task
     */
    public EventCommand(String description, LocalDateTime date1, LocalDateTime date2){
        this.task = new Event(description, date1, date2);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        super.execute(tasks, ui, storage);
    }
}
