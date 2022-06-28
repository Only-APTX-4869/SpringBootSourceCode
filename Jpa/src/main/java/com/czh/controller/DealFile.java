package com.czh.controller;

import java.io.File;

public class DealFile {

    public static void main(String[] args) {
        File file = new File("D:\\workspace_Idea\\SpringBootSourceCode\\Jpa\\src\\main\\resources");
        readFile(file);
    }

    private static void readFile(File file) {
        File[] files = file.listFiles();
        for (File fileName : files) {
            fileName.getName();
        }
    }
}
