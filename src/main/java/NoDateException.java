/**
 * Exception thrown when the user forget the date for a deadline or event task
 */
public class NoDateException extends DukeException {
    /**
     * Constructor
     */
    public NoDateException() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "OOPS!!! The date cannot be empty\n";
    }
}
