import java.util.ArrayList;

public abstract class Command {

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException;

    public boolean isExit(){
        return false;
    }
}
