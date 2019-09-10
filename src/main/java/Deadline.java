import java.time.LocalDateTime;
/**
 * the deadline task
 */
public class Deadline extends Task{

    protected LocalDateTime by;


    /**
     * Constructor
     * @param description the description of a deadline task
     * @param by the deadline of a deadline task
     */
    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    /**
     * Constructor that specifies the whether the task has been completed or not
     * @param description the description of a deadline task
     * @param by the deadline of a deadline task
     * @param isDone if the task has been completed of not
     */
    public Deadline(String description, LocalDateTime by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    /**
     * visualize a deadline task
     * @return the string format to see a deadline task
     */
    public String toString(){
        return "[D]" + super.toString() + " (by " + by.toString() + ")";
    }

    /**
     * to know if whether is a deadline task of not
     * @return true
     */
    public boolean isDeadline(){
        return true;
    }
}
