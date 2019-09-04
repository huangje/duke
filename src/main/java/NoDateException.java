public class NoDateException extends DukeException {
    public NoDateException() {
        super();
    }

    public String getMessage(){
        return "OOPS!!! The date cannot be empty\n";
    }
}
