/**
 * Exception thrown when the task number doesn't correspond to a known task
 */
public class UnknownTaskException extends DukeException {
    /**
     * Constructor
     */
    public UnknownTaskException() {
        super();
    }
    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "Sorry, this task doesn't exist";
    }
}
