import java.util.concurrent.TimeUnit;

public class Replay {
    private FileOperations fileOperations;

    public Boolean load(String s) {
        Boolean result = false;
        fileOperations = new FileOperations(s);
        String[] replayStringArray = fileOperations.stringCut(fileOperations.fileRead(), SetupConf.DELIMITER);
        result = startReplay(replayStringArray);
        return result;
    }

    private Boolean startReplay(String[] replayStringArray) {
        Boolean result;
        for (int i = 0; i < replayStringArray.length; i+=2) {
            String[] timeAndMessage = replayStringArray[i].split(String.valueOf(' '));
            try {
                TimeUnit.SECONDS.sleep(Integer.parseInt(timeAndMessage[0]));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(timeAndMessage[1]);
            System.out.println(replayStringArray[i+1]);
        }
        result = true;
        return result;
    }
    /*stringCut metódus fogadja a karaktert ami mentén darabolja a stringet - kell teszt*/

}
