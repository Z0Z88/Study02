import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class TimeMeasureTest {

    private static TimeMeasure timeMeasure = new TimeMeasure();

    @Test
    public void setStartTimeTest () {
        LocalDateTime tm = LocalDateTime.now();
        timeMeasure.setStartTime(tm);
        Assertions.assertEquals(tm,timeMeasure.getStartTime());
    }

    @Test
    public void calculateElapsedTimeTest () throws InterruptedException {
        LocalDateTime tm = LocalDateTime.now();
        timeMeasure.setStartTime(tm);
        TimeUnit.SECONDS.sleep(2);
        Assertions.assertTrue(timeMeasure.calculateElapsedTime() > 0);
    }
}
