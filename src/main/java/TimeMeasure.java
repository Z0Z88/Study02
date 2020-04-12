import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeMeasure {
    private LocalDateTime startTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Long calculateElapsedTime() {
        Long eTime = (getStartTime().until(LocalDateTime.now(), ChronoUnit.SECONDS));
        System.out.println(eTime);
        return eTime;
    }
}
