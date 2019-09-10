/**
 * Exception thrown when the user's input doesn't correspond to any known command
 */
public class NoCommandException extends DukeException {
    /**
     * Constructor
     */
    public NoCommandException() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }
}
