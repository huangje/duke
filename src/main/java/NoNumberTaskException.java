/**
 * Exception thrown when the task number is not specified for the delete and done command
 */
public class NoNumberTaskException extends DukeException {
    /**
     * Constructor
     */
    public NoNumberTaskException() {
        super();
    }
    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "OOPS! You have to put the task number n\"";
    }
}
