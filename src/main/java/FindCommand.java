import java.util.ArrayList;

/**
 * the find command that will try to find a task from a keyword
 */
public class FindCommand extends Command {

    protected String keyword;

    /**
     * Constructor
     * @param keyword the keyword in order to find the task
     */
    public FindCommand(String keyword){
        this.keyword = keyword;
    }

    /**
     * will find the task and show to the user all the task that correspond to the keyword
     * @param tasks the list of all Task
     * @param ui the class that deals will all interaction with the user
     * @param storage the place where all task will be stock
     * @throws UnknownTaskException not used
     * @throws FileException not used
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws UnknownTaskException, FileException {
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
