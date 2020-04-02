public class Main {

    private int secondNumber;
    private int firstNumber;
    public void setFirstNumber(int i) {
        firstNumber = i;

    }


    public static void main(String[] args) {
       /* Main sumNumbers = new Main();
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

*/
       //Példányosítás
        HiLoEngine hiLoEngine = new HiLoEngine();
        String input;
        do {
            //kiiratás
            System.out.println("Gondoltam egy számra 1 és 100 között, tippelj! (Kilépés-K)");
            //method hívások:
            //randomgenerálás
            hiLoEngine.numberGenerate(100);
            Integer compint = 0;
            do {

                //beolvasás
                input = hiLoEngine.stringRead();
                if (!input.toLowerCase().equals("k")) {
                    hiLoEngine.numberConvert(input);
                    //összehasonlítás
                    compint = hiLoEngine.compareNumber(hiLoEngine.getGuessNumber());
                    //kiiratás
                    if (compint != 0) {
                        System.out.print("A megadott szám");
                        if (compint < 0) {
                            System.out.println(" kissebb mint a gondolt szám");
                        } else if (compint > 0) {
                            System.out.println(" nagyobb mint a gondolt szám");
                        }
                    }
                }
            } while (   compint != 0 &&
                        !input.toLowerCase().equals("k"));
                if (!input.toLowerCase().equals("k")) {
                    System.out.println("\n Gratulálok, eltaláltad! Akarsz mégegyszer játszani? (U)j/(K)ilep");
                    input = hiLoEngine.stringRead();
                }
            //bónuszpont egészet beletenni 1 ciklusba, újrakezdhető legyen
        } while (!input.toLowerCase().equals("k"));

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
