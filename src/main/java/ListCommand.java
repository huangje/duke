/**
 * the list command that will show us all the task
 */
public class ListCommand extends Command{


    /**
     * will show all the task i the task list
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException not used
     * @throws FileException not used
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        ui.showList(tasks);
    }
}
