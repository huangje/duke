import java.util.ArrayList;

public class FindCommand extends Command {

    protected String keyword;

    public FindCommand(String keyword){
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException {
        ArrayList<Task> findTasks = new ArrayList<>();
        ArrayList<Integer> listIndexTask= new ArrayList<>();
        int index = 1;
        for (Task t : tasks.tasks){
            if(t.description.contains(this.keyword)){
                findTasks.add(t);
                listIndexTask.add(index);
                index++;
            }
        }
        ui.showFind(findTasks, listIndexTask);
    }
}
