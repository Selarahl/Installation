package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static StringBuilder log = new StringBuilder();
    private static final String WAY = "F://NETOLOGY/Games";

    private static final List<String> CREATION_DIR = Arrays.asList(
            WAY + "/src", WAY + "/res", WAY + "/savegames", WAY + "/temp",
            WAY + "/src/main", WAY + "/src/test",
            WAY + "/res/drawables", WAY + "/res/vectors", WAY + "/res/icons"
    );

    private static final List<String> CREATION_FILE = Arrays.asList(
            WAY + "/src/main/Main.java", WAY + "/src/main/Utils.java",
            WAY + "/temp/temp.txt"
    );

    public static void main(String[] args) {

        for (String dirPath : CREATION_DIR) {
            File dir = new File(dirPath);
            creationLog(dir, dir.mkdir());
        }

        for (String filePath : CREATION_FILE) {
            File file = new File(filePath);
            try {
                creationLog(file, file.createNewFile());
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeLog(new File(WAY + "/temp/temp.txt"));

    }

    private static void creationLog(File file, boolean result) {
        log.append(file.isDirectory() ? "Каталог " : "Файл ")
                .append(file.getName())
                .append(result ? " Создан" : " Не создан")
                .append((!result && file.exists()) ? " , потому что уже существует!" : " ")
                .append((!result && file.exists()) ? " , потому что не найден!" : " ")
                .append("\n");
    }

    private static void writeLog(File file) {
        try (FileWriter fileWrite = new FileWriter(file)) {
            fileWrite.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

