/**
 * the todo command that will add a todo task
 */
public class TodoCommand extends AddCommand {


    /**
     * Constructor
     * @param description the description of a todo task
     */
    public TodoCommand(String description){
        task = new Todo(description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        super.execute(tasks, ui, storage);
    }
}
