/**
 * The delete command that will delete a task
 */
public class DeleteCommand extends Command {
    protected int indexTask;
    /**
     * Constructor
     * @param index the task number that will be deleted
     */
    public DeleteCommand(int index){
        this.indexTask = index;
    }

    /**
     * delete the task, show the deleted task and update the history
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException throws exception when the task number doesn't correspond to an task
     * @throws FileException throws exception when there are some problems with the storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        if(this.indexTask > tasks.tasks.size() || this.indexTask < 0){
            throw new UnknownTaskException();
        }
        else {
            Task task = tasks.deleteTask(indexTask - 1);
            ui.showDelete(task, indexTask);
            storage.save(tasks.tasks);
        }
    }
}
