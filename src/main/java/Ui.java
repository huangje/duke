import java.util.ArrayList;

public class Ui {



    public void showError(String error){
        System.out.println(error);
    }

    public void showLine(){
        System.out.println("\n______________________________________________________________\n");
    }

    public void showList(TaskList tasks){
        int indexTask = 1;
        System.out.println("Here are the tasks in your list: \n");
        for (Task t : tasks.tasks){
            System.out.println(indexTask + "." + t.toString());
            indexTask++;
        }
    }

    public void showDelete(Task task, int numberTask){
        System.out.println("Noted. I've removed this task: \n" +
                task.toString() + "\n" + "Now you have " + numberTask + " tasks in the list \n");
    }

    public void showDone(Task task){
        System.out.println("Nice! I've marked this task as done : \n" +
                task.toString());
    }

    public void showExit(){
        System.out.println("Bye. Hope to see you again soon !");
    }

    public void showFind(ArrayList<Task> tasks, ArrayList<Integer> listIndexTask){
        System.out.println("Here are the matching tasks in your list: \n");
        int index = 0;
        for (Task t : tasks){
            System.out.println(listIndexTask.get(index) + "." + t.toString());
            index++;
        }
    }

    public void showAdd(Task task, int numberTask){
        System.out.println("Got it. I've added this task : \n" + task.toString() +
                "\nNow you have " + numberTask + " tasks in the list");
    }
}
