import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

        String newLine;

        public String getNewLine() {
                return newLine;
        }

        public void setNewLine(String newLine) {
                this.newLine = newLine;
        }

        public String readNewLine() {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                String result = null;
                try {
                        result = bf.readLine();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return result;

        }

}

/*todo w/s (setup confból jöjjön a w/s: billentyűkiosztás átállítás) billentyű leütését figyelni consoleon menühöz*/
