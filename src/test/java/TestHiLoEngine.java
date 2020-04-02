import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHiLoEngine {

    private static HiLoEngine hiLoEngine = new HiLoEngine();

    @Test
    public void numberConvertTest () {
        Assertions.assertNull(hiLoEngine.getGuessNumber());
        hiLoEngine.numberConvert ("5");
        Assertions.assertNotNull(hiLoEngine.getGuessNumber());
    }

    @Test
    public void numberConvertExceptionTest () {
        Assertions.assertThrows(NumberFormatException.class, () -> hiLoEngine.numberConvert("r"));
    }

    @Test
    public void numberGenerateTest () {
        Assertions.assertNull(hiLoEngine.getNumber());
        hiLoEngine.numberGenerate (100d);
        Assertions.assertNotNull(hiLoEngine.getNumber());
    }

    @Test
    public void compareNumberTest () {
        hiLoEngine.setNumber (12);
        Assertions.assertEquals(-10, hiLoEngine.compareNumber (2));
        Assertions.assertEquals(10, hiLoEngine.compareNumber (22));
        Assertions.assertEquals(0, hiLoEngine.compareNumber (12));
    }
}
