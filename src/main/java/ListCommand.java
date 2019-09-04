import java.util.ArrayList;

public class ListCommand extends Command{


    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException {
        ui.showList(tasks);
    }
}
