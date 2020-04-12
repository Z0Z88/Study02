import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class HiLoEngine {
    private Integer guessNumber;
    private Integer number;
    private TimeMeasure timeMeasure = new TimeMeasure();
    private FileOperations fileOperations;

    public HiLoEngine(FileOperations fileOperations) {
        this.fileOperations = fileOperations;
    }

    public Integer getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(Integer guessNumber) {
        this.guessNumber = guessNumber;
    }

    public void numberConvert(String input) throws NumberFormatException {
        Integer num = Integer.parseInt(input);
        setGuessNumber(num);
    }

    public String stringRead() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputText = null;
        timeMeasure.setStartTime(LocalDateTime.now());
        try {
            inputText = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //File-ba
        //timeMeasure.calculateElapsedTime();
        String cacheString = (timeMeasure.calculateElapsedTime() + SetupConf.TIME_GUESS_DELIMITER + inputText);
        fileOperations.fileWrite(cacheString);
        inputText = checkString(inputText);
        return inputText;
    }

    private String checkString(String inputText) {
        if (!inputText.toLowerCase().equals(SetupConf.QUIT_COMMAND)) {
            try {
                Integer.parseInt(inputText);
            } catch (NumberFormatException ex) {
                fileOperations.fileWrite(SetupConf.WRONG_CHRS_MSG);
                System.out.println(SetupConf.WRONG_CHRS_MSG);
                inputText = stringRead();
            }
        }
        return inputText;
    }

    public Integer getNumber() {
        return number;
    }

    public void numberGenerate(double i) {
        number = (int) (Math.random() * i);
    }

    public void setNumber(int i) {
        number = i;
    }

    public Integer compareNumber(int i) {
        Integer result;
        result = i - number;
        return result;
    }
}
