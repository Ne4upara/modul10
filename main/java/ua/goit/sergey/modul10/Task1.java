package ua.goit.sergey.modul10;

import java.io.*;

public class Task1 {

   private final File file;

    public Task1 (String file){
        this(new File(file));
    }

    public Task1 (File file){
        this.file = file;
    }

    public void selection() {
       try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = reader.readLine();
            while (line != null){
                if (line.matches("[(]\\d{3}[)][ ]\\d{3}[-]\\d{4}") ||
                    line.matches("\\d{3}[-]\\d{3}[-]\\d{4}")){
                    System.out.println(line);
                }
                line = reader.readLine();
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}