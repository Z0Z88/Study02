import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputReaderTest {

    InputReader inputReader = new InputReader();

    @Test
    public void getNewLineTest(){
        inputReader.setNewLine("Új sor");
        Assertions.assertEquals("Új sor", inputReader.getNewLine());
    }
}
