public class InvalidDateExceptionDeadline extends DukeException{

    public InvalidDateExceptionDeadline(){
        super();
    }

    public String getMessage(){
        return "OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM\n";
    }
}
