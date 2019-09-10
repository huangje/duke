import java.time.LocalDateTime;
/**
 * the event task
 */
public class Event extends Task {

    protected LocalDateTime at1;
    protected LocalDateTime at2;

    /**
     * Constructor
     * @param description the description of a deadline task
     * @param at1 the start date of a deadline task
     * @param at2 the end date of a deadline task
     */
    public Event(String description, LocalDateTime at1, LocalDateTime at2) {
        super(description);
        this.at1 = at1;
        this.at2 = at2;
    }

    /**
     * Constructor that specifies the whether the task has been completed or not
     * @param description the description of a deadline task
     * @param at1 the start date of a deadline task
     * @param at2 the end date of a deadline task
     * @param isDone if the task has been completed of not
     */
    public Event(String description, LocalDateTime at1, LocalDateTime at2, boolean isDone) {
        super(description, isDone);
        this.at1 = at1;
        this.at2 = at2;
    }
    /**
     * visualize a event task
     * @return the string format to see a event task
     */
    public String toString(){
        return "[E]" + super.toString() + " (at " + at1.toString() + " " + at2.toString() +")";
    }
    /**
     * to know if whether is an event task of not
     * @return true
     */
    public boolean isEvent(){
        return true;
    }
}
