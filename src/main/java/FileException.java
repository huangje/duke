public class FileException extends DukeException {

    public FileException(){
        super();
    }

    public String getMessage(){
        return "File doesn't exist or cannot be created or cannot be opened";
    }
}
