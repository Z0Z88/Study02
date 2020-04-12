import java.io.*;
import java.util.Scanner;

public class FileOperations {

    private File file;
    private FileWriter fileWriter;
    private Scanner fileScanner;


    public FileOperations() {
    }



    public FileOperations(String fileName) {
        file = new File(fileName);

    }

    public Boolean fileCreation(String fileName) {
        Boolean result = false;
        file = new File(fileName);


        try {
            result = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!result) {
            try {
                fileWriter = new FileWriter(file.getName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public boolean fileDelete() {
        Boolean result = false;
        result = file.delete();
        return result;
    }

    public void fileWrite(String tartalom) {
        try {
            String s = fileRead();
            fileWriter = new FileWriter(file.getName());
            if (s.equals("")) {
                fileWriter.write(tartalom);
            } else {
                fileWriter.write(s + SetupConf.DELIMITER + tartalom);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fileRead() {
        String result = "";
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine())
            result = fileScanner.nextLine();
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }

    public String[] stringCut(String s, String d) {
        String[] split = s.split(d);
        return split;
    }
}
