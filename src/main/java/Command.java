/**
 * Command is the abstract class for all the command context which allow us to create or manipulate task
 */
public abstract class Command {

    /**
     *
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException exception throws when user try to delete or complete a task that doesn't exist
     * @throws FileException exception throws when there is some problem with the history file
     */
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException;

    /**
     * Return a boolean to know if it's an ExitComand
     * @return false when it's not an ExitCommand
     */
    public boolean isExit(){
        return false;
    }
}
