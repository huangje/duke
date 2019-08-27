public class Event extends Task {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    public String toString(){
        return "[E]" + super.toString() + "(at" + at +")";
    }

    public boolean isEvent(){
        return true;
    }
}