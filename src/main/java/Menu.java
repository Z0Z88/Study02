import java.io.IOException;

public class Menu {

    Replay replay = new Replay();
    HiLoGame hiLoGame = new HiLoGame();
    InputReader inputReader = new InputReader();


    public void loopMenu(){
        do {
            printMenu();
        }  while (!inputReader.getNewLine().equals(SetupConf.QUIT_COMMAND));

    }

    private void printMenu() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("Üdv! Válassz az alábbi lehetőségek közül:");
        System.out.println(SetupConf.MENU_GAME_BUTTON + ": Új játék indítása");
        System.out.println(SetupConf.MENU_REPLAY_BUTTON + ": Előző játék visszajátszása");
        System.out.println(SetupConf.QUIT_COMMAND + ": Kilépés");
        inputReader.setNewLine(inputReader.readNewLine());
        selectMenuPoint(inputReader.getNewLine());
    }

    private void selectMenuPoint(String inputKey){
        switch (inputKey) {
            case SetupConf.MENU_GAME_BUTTON:
                hiLoGame.game();
                break;
            case SetupConf.MENU_REPLAY_BUTTON:
                replay.load("log.txt");
                break;
            case SetupConf.QUIT_COMMAND:
                System.out.println(SetupConf.BYE);
                break;
            default:
                System.out.println(SetupConf.WRONG_CHRS_MSG);
                inputReader.setNewLine(inputReader.readNewLine());
                selectMenuPoint(inputReader.getNewLine());
                break;
        }
    }
}
