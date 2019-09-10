import java.util.ArrayList;

/**
 * will contains all the tasks
 */
public class TaskList {
    protected ArrayList<Task> tasks;

    /**
     * Constructor
     * @param tasks the array of tasks
     * @throws EmptyTaskException thrown when there is no task to be initialized
     */
    public TaskList(ArrayList<Task> tasks) throws EmptyTaskException {
        if(tasks.size() == 0){
            throw new EmptyTaskException();
        }
        else {
            this.tasks = tasks;
        }
    }

    /**
     * Constructor called when there is no task in the file
     */
    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    /**
     * add a task to the array
     * @param task the task to be added
     */
    public void addTask(Task task){
        this.tasks.add(task);
    }

    /**
     * remove a task from the list and return it
     * @param indexTask task number
     * @return a task
     */
    public Task deleteTask(int indexTask){
        return this.tasks.remove(indexTask);
    }
}
