import java.time.LocalDateTime;

public class Event extends Task {

    protected LocalDateTime at;

    public Event(String description, LocalDateTime at) {
        super(description);
        this.at = at;
    }

    public Event(String description, LocalDateTime at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    public String toString(){
        return "[E]" + super.toString() + " (at " + at.toString() +")";
    }

    public boolean isEvent(){
        return true;
    }
}
