public class UnknownTaskException extends DukeException {
    public UnknownTaskException() {
        super();
    }

    public String getMessage(){
        return "Sorry, this task doesn't exist";
    }
}
