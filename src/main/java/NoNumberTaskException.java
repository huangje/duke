public class NoNumberTaskException extends DukeException {

    public NoNumberTaskException() {
        super();
    }

    public String getMessage(){
        return "OOPS! You have to put the number of the task n\"";
    }
}
