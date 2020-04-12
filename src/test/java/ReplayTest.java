import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReplayTest {
    private static Replay replay= new Replay();

    @Test
    public void loadTest(){
        Boolean bl = replay.load("log.txt");
        Assertions.assertTrue(bl);
    }
}
