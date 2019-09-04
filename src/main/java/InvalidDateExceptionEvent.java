public class InvalidDateExceptionEvent extends DukeException {

    public InvalidDateExceptionEvent(){
        super();
    }

    public String getMessage(){
        return "OOPS!!! The date format is invalid, please write as DD/MM/YYYY HHMM - DD/MM/YYYY HHMM or the date doesn't exist\n";
    }
}
