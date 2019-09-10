public class DoneCommand extends Command {
    protected int indexTask;

    /**
     * Constructor
     * @param index the task number that has to be marked as completed
     */
    public DoneCommand(int index){
        this.indexTask = index;
    }

    /**
     * update the task list, show the message, and save it to the history
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
            tasks.tasks.get(indexTask - 1).isDone = true;
            ui.showDone(tasks.tasks.get(indexTask - 1));
            storage.save(tasks.tasks);
        }
    }
}
