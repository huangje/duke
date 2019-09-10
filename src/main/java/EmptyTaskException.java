/**
 * Exception thrown when there is no task to initialized the task list
 */
public class EmptyTaskException extends DukeException {
    /**
     * Constructor
     */
    public EmptyTaskException() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "There are no task";
    }
}
