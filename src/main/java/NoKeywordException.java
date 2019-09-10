/**
 * Exception thrown when the user forgot the keyword for the find command
 */
public class NoKeywordException extends DukeException {
    /**
     * Constructor
     */
    public NoKeywordException() {
        super();
    }
    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "OOPS! You forgot to write the keyword \n";
    }
}
