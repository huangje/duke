import java.util.ArrayList;
import java.util.Scanner;

/**
 * deal with the interaction between the user and the software
 */
public class Ui {
    private Scanner sc;

    /**
     * Constructor
     */
    public Ui(){
        sc = new Scanner(System.in);
    }

    /**
     * show the exception message
     * @param error exception message
     */
    public void showError(String error){
        System.out.println(error);
    }

    /**
     * a line
     */
    public void showLine(){
        System.out.println("\n______________________________________________________________\n");
    }

    /**
     * shows all the tasks
     * @param tasks the list of task
     */
    public void showList(TaskList tasks){
        int indexTask = 1;
        System.out.println("Here are the tasks in your list: \n");
        for (Task t : tasks.tasks){
            System.out.println(indexTask + "." + t.toString());
            indexTask++;
        }
    }

    /**
     * show the task that has been deleted
     * @param task the task that has been deleted
     * @param numberTask the number of tasks remaining
     */
    public void showDelete(Task task, int numberTask){
        System.out.println("Noted. I've removed this task: \n" +
                task.toString() + "\n" + "Now you have " + numberTask + " tasks in the list \n");
    }

    /**
     * show the task that has been marked as done
     * @param task the task that has been done
     */
    public void showDone(Task task){
        System.out.println("Nice! I've marked this task as done : \n" +
                task.toString());
    }

    /**
     * show the exit message
     */
    public void showExit(){
        System.out.println("Bye. Hope to see you again soon !");
    }

    /**
     * show all the tasks corresponding to the find keyword
     * @param tasks the tasks corresponding to the find keyword
     * @param listIndexTask the task number
     */
    public void showFind(ArrayList<Task> tasks, ArrayList<Integer> listIndexTask){
        System.out.println("Here are the matching tasks in your list: \n");
        int index = 0;
        for (Task t : tasks){
            System.out.println(listIndexTask.get(index) + "." + t.toString());
            index++;
        }
    }

    /**
     * show the task that has been add
     * @param task the task that has been add
     * @param numberTask the total number of tasks
     */
    public void showAdd(Task task, int numberTask){
        System.out.println("Got it. I've added this task : \n" + task.toString() +
                "\nNow you have " + numberTask + " tasks in the list");
    }

    /**
     * show the welcome message
     */
    public void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * show the error message when no task were loaded
     */
    public void showLoadingError(){
        System.out.println("No task were loaded");
    }

    /**
     * read the nextline of the scanner
     * @return return the user's input
     */
    public String readCommand(){
        return sc.nextLine();
    }
}
