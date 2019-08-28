import java.time.LocalDateTime;

public class Deadline extends Task{
    protected LocalDateTime by;


    public Deadline(String description, LocalDateTime by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, LocalDateTime by, boolean isDone) {
        super(description, isDone);
        this.by = by;
    }

    public String toString(){
        return "[D]" + super.toString() + " (by " + by.toString() + ")";
    }

    public boolean isDeadline(){
        return true;
    }
}
