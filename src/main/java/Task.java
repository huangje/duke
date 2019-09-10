/**
 * Task is the abstract class for all the task context
 */

public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor in abstract task in order to simplify the code
     * @param description the description of a task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Constructor in abstract task in order to simplify the code that specifies the whether
     * the task has been completed or no
     * @param description the description of a task
     * @param isDone if the task has been completed of not
     */
    public Task(String description, boolean isDone){
        this.description = description;
        this.isDone = isDone;
    }

    /**
     * create a string depending of the isdone
     * @return check box
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * visualize a event task
     * @return the string format to see a task
     */
    public String toString(){
        return "[" + getStatusIcon()+ "] " + this.description;
    }

    /**
     * to know if whether is a deadline task of not
     * @return false
     */
    public boolean isDeadline(){
        return false;
    }
    /**
     * to know if whether is a todo task of not
     * @return false
     */
    public boolean isTodo(){
        return false;
    }
    /**
     * to know if whether is an event task of not
     * @return false
     */
    public boolean isEvent(){
        return false;
    }


}
