import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMain {

    private final Main myTestClass = new Main();

    @Test
    public void setFirstNumberTest() {
        myTestClass.setFirstNumber(883676);
        Assertions.assertEquals(883676, myTestClass.getFirstNumber());

    }



    @Test
    public void setSecondNumberTest() {

        myTestClass.setSecondNumber(11);
        Assertions.assertEquals(11, myTestClass.getSecondNumber());
        myTestClass.setSecondNumber(12);
        Assertions.assertEquals(12, myTestClass.getSecondNumber());
    }


    @Test
    public void getFirstNumberTest() {

        myTestClass.setFirstNumber(11);
        Assertions.assertEquals(11, myTestClass.getFirstNumber());
        myTestClass.setFirstNumber(12);
        Assertions.assertEquals(12, myTestClass.getFirstNumber());
    }

    @Test
    public void getSecondNumberTest() {

        myTestClass.setSecondNumber(11);
        Assertions.assertEquals(11, myTestClass.getSecondNumber());
        myTestClass.setSecondNumber(1);
        Assertions.assertEquals(1, myTestClass.getSecondNumber());
    }


    @Test
    public void getSumTest () {
        myTestClass.setFirstNumber(11);
        myTestClass.setSecondNumber(12);
        Assertions.assertEquals(23, myTestClass.getSum());
        myTestClass.setFirstNumber(11);
        myTestClass.setSecondNumber(1);
        Assertions.assertEquals(12, myTestClass.getSum());
    }

}
