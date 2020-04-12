class HiLoGame {

    public static final String TNUMBER_GREATER = "A gondolt szám nagyobb";
    public static final String TNUMBER_SMALLER = "A gondolt szám kissebb";
    public static final String GRAT_CON_OR_EXIT = "\n Gratulálok, eltaláltad! Akarsz mégegyszer játszani? (U)j/(K)ilep";


    public void game(){
        FileOperations fileOperations = new FileOperations();
        fileOperations.fileCreation("log.txt");
        HiLoEngine hiLoEngine = new HiLoEngine(fileOperations);
        String input;
        do {
            //kiiratás
            System.out.println("Gondoltam egy számra 1 és " + SetupConf.MAX_RANDON_VALUE + " között, tippelj! (Kilépés-"+ SetupConf.QUIT_COMMAND +")");

            //method hívások:
            //randomgenerálás
            hiLoEngine.numberGenerate(SetupConf.MAX_RANDON_VALUE);
            Integer compint = 0;
            do {

                //beolvasás
                input = hiLoEngine.stringRead();
                if (!input.toLowerCase().equals(SetupConf.QUIT_COMMAND)) {
                    hiLoEngine.numberConvert(input);
                    //összehasonlítás
                    compint = hiLoEngine.compareNumber(hiLoEngine.getGuessNumber());
                    //kiiratás
                    if (compint != 0) {
                        if (compint < 0) {
                            System.out.println(TNUMBER_GREATER);
                            fileOperations.fileWrite(TNUMBER_GREATER);
                        } else if (compint > 0) {
                            System.out.println(TNUMBER_SMALLER);
                            fileOperations.fileWrite(TNUMBER_SMALLER);
                        }
                    }
                }
            } while (   compint != 0 && !input.toLowerCase().equals(SetupConf.QUIT_COMMAND));
            if (!input.toLowerCase().equals(SetupConf.QUIT_COMMAND)) {
                System.out.println(GRAT_CON_OR_EXIT);
                fileOperations.fileWrite(GRAT_CON_OR_EXIT);
                input = hiLoEngine.stringRead();
            }
            //bónuszpont egészet beletenni 1 ciklusba, újrakezdhető legyen
        } while (!input.toLowerCase().equals(SetupConf.QUIT_COMMAND));
        System.out.println(SetupConf.BYE);
        fileOperations.fileWrite(SetupConf.BYE);
    }
}
