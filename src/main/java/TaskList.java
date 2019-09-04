import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) throws EmptyTaskException {
        if(tasks.size() == 0){
            throw new EmptyTaskException();
        }
        else {
            this.tasks = tasks;
        }
    }

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void deleteTask(int indexTask){
        Task task = this.tasks.remove(indexTask);
    }
}
