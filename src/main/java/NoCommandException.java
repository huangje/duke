public class NoCommandException extends DukeException {
    public NoCommandException() {
        super();
    }

    public String getMessage(){
        return "OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    }
}
