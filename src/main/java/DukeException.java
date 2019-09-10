/**
 * the superclass that contains all the duke exception
 */
public class DukeException extends Exception {
    public DukeException(){
        super();
    }

    /**
     * show the error message
     * @return the error message
     */
    @Override
    public String getMessage(){
        return "There are some problems in Duke";
    }
}
