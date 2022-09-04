package com.czh.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class RedaerAndWriter {
    private static File file;

    public static void main(String[] args) throws IOException {
        file = new File("D:\\workspace_Idea\\SpringBootSourceCode\\Jpa\\src\\main\\resources");
        System.out.println("source address" + file + "\\sumTxt.txt");
        readFileController(file);
    }

    private static void readFileController(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File filePath : files) {
                if (filePath.isDirectory() || filePath.length() > 0) {
                    readFileController(filePath);
                }
                readFileService(filePath);
            }
        } else {
            readFileService(file);
        }
    }

    private static void readFileService(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file + "\\sumTxt.txt");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        String readLine = "";
        while ((readLine = bfr.readLine()) != null) {
            bfw.write(readLine);
        }
        if (readLine == null) {
            bfw.write("写入完毕 文件名是");
        }
        bfw.close();
        bfr.close();
        fos.close();
        fis.close();
    }

}
