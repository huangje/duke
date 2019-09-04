public class NoKeywordException extends DukeException {

    public NoKeywordException() {
        super();
    }

    public String getMessage(){
        return "OOPS! You forgot to write the keyword \n";
    }
}
