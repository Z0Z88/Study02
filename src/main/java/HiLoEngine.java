import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HiLoEngine {
    private Integer guessNumber;
    private Integer number;

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
        try {
            inputText = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        inputText = checkString(inputText);
        return inputText;
    }

    private String checkString(String inputText) {
        if (!inputText.toLowerCase().equals("k")) {
            try {
                Integer.parseInt(inputText);
            } catch (NumberFormatException ex) {
                System.out.println("Nem engedélyezett karakter! Adj meg egy másikat:");
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
