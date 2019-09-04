import java.util.ArrayList;

public abstract class AddCommand extends Command {

    Task task;
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException{
        tasks.addTask(this.task);
        ui.showAdd(this.task, tasks.tasks.size());
        storage.save(tasks.tasks);
    }
}
