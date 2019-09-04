public class DukeException extends Exception {
    public DukeException(){
        super();
    }

    @Override
    public String getMessage(){
        return "There are some problems in Duke";
    }
}
