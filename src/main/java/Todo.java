/**
 * the todo task
 */
public class Todo extends Task {

    /**
     * Constructor
     * @param description the description of a todo task
     */
    public Todo(String description){
        super(description);
    }

    /**
     * Constructor that specifies the whether the task has been completed or not
     * @param description description the description of a todo task
     * @param isDone if the task has been completed of not
     */
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }
    /**
     * visualize a event task
     * @return the string format to see a event task
     */
    public String toString(){
        return "[T]" + super.toString();
    }
    /**
     * to know if whether is a todo task of not
     * @return true
     */
    public boolean isTodo(){
        return true;
    }
}
