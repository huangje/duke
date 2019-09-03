import java.time.LocalDateTime;

public class Event extends Task {

    protected LocalDateTime at1;
    protected LocalDateTime at2;

    public Event(String description, LocalDateTime at1, LocalDateTime at2) {
        super(description);
        this.at1 = at1;
        this.at2 = at2;
    }

    public Event(String description, LocalDateTime at1, LocalDateTime at2, boolean isDone) {
        super(description, isDone);
        this.at1 = at1;
        this.at2 = at2;
    }

    public String toString(){
        return "[E]" + super.toString() + " (at " + at1.toString() + " " + at2.toString() +")";
    }

    public boolean isEvent(){
        return true;
    }
}
