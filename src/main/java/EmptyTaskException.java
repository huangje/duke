public class EmptyTaskException extends DukeException {
    public EmptyTaskException() {
        super();
    }

    public String getMessage(){
        return "There are no task";
    }
}
