import java.util.ArrayList;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException {
        storage.save(tasks.tasks);
        ui.showExit();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
