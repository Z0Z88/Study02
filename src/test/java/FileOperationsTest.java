import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileOperationsTest {

    FileOperations fileOperations = new FileOperations();

    @Test
    public void fileCreationTest() {
        Assertions.assertTrue(fileOperations.fileCreation("testfile.dat"));
        fileOperations.fileDelete();
    }

    @Test
    public void fileReadTest() {
        fileOperations.fileCreation("testfile.dat");
        fileOperations.fileWrite("Tartalom");
        String containedString = fileOperations.fileRead();
        Assertions.assertEquals("Tartalom", containedString);
        fileOperations.fileDelete();
    }

    @Test
    public void fileWriteTest() {
        fileOperations.fileCreation("testfile.dat");
        fileOperations.fileWrite("Tartalom");
        Assertions.assertEquals(fileOperations.fileRead(), "Tartalom");
        fileOperations.fileDelete();
    }

    @Test
    public void fileDeleteTest() {
        fileOperations.fileCreation("testfile.dat");
        Assertions.assertTrue(fileOperations.fileDelete());
    }

    @Test
    public void stringCutTest() {
        String[] originalStringArray = fileOperations.stringCut("abcßdef", SetupConf.DELIMITER);
        String[] compareStringArray = {"abc","def"};
        Assertions.assertArrayEquals(compareStringArray,originalStringArray);
    }

    @Test
    public void altStringCutTest() {
        String[] originalStringArray = fileOperations.stringCut("abc def", SetupConf.TIME_GUESS_DELIMITER);
        String[] compareStringArray = {"abc","def"};
        Assertions.assertArrayEquals(compareStringArray,originalStringArray);
    }
}
