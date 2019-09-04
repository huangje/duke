public class NoDescriptionException extends DukeException {

    public NoDescriptionException() {
        super();
    }

    public String getMessage(){
        return "OOPS!!! The description of a deadline cannot be empty\n";
    }
}
