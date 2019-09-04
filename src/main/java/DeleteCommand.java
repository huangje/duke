import java.util.ArrayList;

public class DeleteCommand extends Command {
    protected int indexTask;
    public DeleteCommand(int index){
        this.indexTask = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException {
        if(this.indexTask > tasks.tasks.size() || this.indexTask < 0){
            throw new UnknownTaskException("Sorry, this task doesn't exist");
        }
        else {
            Task task = tasks.tasks.remove(indexTask - 1);
            ui.showDelete(task, indexTask);
            storage.save(tasks.tasks);
        }
    }
}
