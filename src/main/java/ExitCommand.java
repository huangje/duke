public class ExitCommand extends Command {

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
        storage.save(tasks.tasks);
        ui.showExit();
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
