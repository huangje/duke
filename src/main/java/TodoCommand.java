import java.util.ArrayList;

public class TodoCommand extends AddCommand {


    public TodoCommand(String description){
        task = new Todo(description);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException{
        super.execute(tasks, ui, storage);
    }
}
