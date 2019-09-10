/**
 * the exit command that will exit the software
 */
public class ExitCommand extends Command {

    /**
     * save every task to the history file and exit the software
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException not used
     * @throws FileException throws exception when there are some problems with the storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        storage.save(tasks.tasks);
        ui.showExit();
    }

    /**
     * check if it is an exit command
     * @return true
     */
    @Override
    public boolean isExit(){
        return true;
    }
}
