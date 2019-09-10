/**
 * Exception thrown when there is no description for a task
 */
public class NoDescriptionException extends DukeException {

    /**
     * Constructor
     */
    public NoDescriptionException() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "OOPS!!! The description of a task cannot be empty\n";
    }
}
