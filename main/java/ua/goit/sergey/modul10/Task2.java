package ua.goit.sergey.modul10;

import java.io.*;
import java.util.Scanner;

public class Task2 {

    private final File txt;
    private final File json;

    public Task2(String txt, String json){
        this(new File(txt), new File(json));
    }

    public Task2 (File txt, File json){
        this.txt=txt;
        this.json=json;
    }

    public void conversion() throws FileNotFoundException {
        FileInputStream fileIS = new FileInputStream(txt);
        File fileJson = new File(json.toURI());
        checkFile(fileJson);

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        Scanner scanner = new Scanner(fileIS);
        String test = scanner.nextLine();
        String[] first = test.split(" ");

        while (scanner.hasNextLine()) {
            sb.append("\t { \n");
            String arr = scanner.nextLine();
            String[] second = arr.split(" ");
            for (int i = 0; i < first.length; i++) {
                if (!new Scanner(first[i]).hasNextInt())
                {
                    sb.append("\"" + first[i] + "\" : ");
                }
                else sb.append(first[i] + " : ");
                if (!isNumeric(second[i]) &&
                    !second[i].equals("true") &&
                    !second[i].equals("false"))
                {
                    sb.append("\"" + second[i] + "\" , \n");
                }
                else sb.append(second[i] + " , \n");
                if (i == first.length - 1)
                {
                    sb.delete(sb.length() - 3, sb.length());
                    sb.append("\n \t }, \n");
                }
            }
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append("\n ]");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileJson)))
        {
            bufferedWriter.write(sb.toString());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Выполнено!");
    }

    private static void checkFile (File file) {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




