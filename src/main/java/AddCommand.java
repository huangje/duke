/**
 * Represent all the commands that can add a task
 */

public abstract class AddCommand extends Command {

    Task task;

    /**
     * add the task to the task list, show the message, and save the task to the history file
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException not used
     * @throws FileException throws exception when there are some problems with the storage
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        tasks.addTask(this.task);
        ui.showAdd(this.task, tasks.tasks.size());
        storage.save(tasks.tasks);
    }
}
