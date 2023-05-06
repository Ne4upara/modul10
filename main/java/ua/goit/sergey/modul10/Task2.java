package ua.goit.sergey.modul10;

import java.io.*;
import java.util.Scanner;

public class Task2 {

    private final File inputFile;
    private final File outputFile;

    private StringBuilder sb;

    public Task2(String inputFile, String outputFile){
        this(new File(inputFile), new File(outputFile));
    }

    public Task2 (File inputFile, File outputFile){
        this.inputFile=inputFile;
        this.outputFile=outputFile;
    }

    public void conversion() {

        sb = new StringBuilder();
        sb.append("[\n");
        try(Scanner scanner = new Scanner(inputFile)) {
            String test = scanner.nextLine();
            String[] first = test.split(" ");
            while (scanner.hasNextLine()) {
                sb.append("\t { \n");
                String arr = scanner.nextLine();
                String[] second = arr.split(" ");
                for (int i = 0; i < first.length; i++) {
                    if (!new Scanner(first[i]).hasNextInt()) {
                        sb.append("\"" + first[i] + "\" : ");
                    } else sb.append(first[i] + " : ");
                    if (!isNumeric(second[i]) &&
                            !second[i].equals("true") &&
                            !second[i].equals("false")) {
                        sb.append("\"" + second[i] + "\" , \n");
                    } else sb.append(second[i] + " , \n");
                    if (i == first.length - 1) {
                        sb.delete(sb.length() - 3, sb.length());
                        sb.append("\n \t }, \n");
                    }
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        sb.delete(sb.length() - 3, sb.length());
        sb.append("\n ]");
        outputFileSave();
    }

        private void outputFileSave(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(outputFile.toURI()))))
        {
            bufferedWriter.write(sb.toString());
            System.out.println("Выполнено!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
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




