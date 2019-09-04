public class TodoCommand extends AddCommand {


    public TodoCommand(String description){
        task = new Todo(description);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        super.execute(tasks, ui, storage);
    }
}
