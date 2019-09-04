public class DoneCommand extends Command {
    protected int indexTask;

    public DoneCommand(int index){
        this.indexTask = index;
    }

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
