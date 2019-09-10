/**
 * Exception thrown when there is a problem with the file like.
 * For example when the file doesn't exist, can't be read or written
 */
public class FileException extends DukeException {

    /**
     * Constructor
     */
    public FileException(){
        super();
    }
    /**
     * {@inheritDoc}
     */
    public String getMessage(){
        return "File doesn't exist or cannot be created or cannot be opened";
    }
}
