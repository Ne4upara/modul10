package ua.goit.sergey.modul10;

import java.io.IOException;

public class TaskTest {

    public static void main(String[] args) throws IOException {
        System.out.println("\nПример первого задания. ");
        new Task1("./src/main/resources/text1.txt").selection();

        System.out.println("\n\nВыполняетса второе задание.");
        new Task2("./src/main/resources/text2.txt","./src/main/resources/user.json").conversion();

        System.out.println("\n\nПример третьего задания. ");
        new Task3("./src/main/resources/text3.txt").searchWord();
    }
}
