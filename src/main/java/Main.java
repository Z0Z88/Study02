import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    private int secondNumber;
    private int firstNumber;

    public void setFirstNumber(int i) {
        firstNumber = i;

    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.loopMenu();

    }


    public static void sumNumMain ( ) {
        Main sumNumbers = new Main();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Add meg az első számot:");
        try {
            sumNumbers.setFirstNumber(Integer.parseInt(bf.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Add meg a második számot:");
        try {
            sumNumbers.setSecondNumber(Integer.parseInt(bf.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("A két szám összege:"+sumNumbers.getSum());


    }

    public void setSecondNumber(int i) {
        secondNumber = i;
    }



    public int getSecondNumber() {
        return (secondNumber);
    }


    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSum() {
        return firstNumber+secondNumber;
    }
}
