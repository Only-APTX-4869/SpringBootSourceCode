package com.czh.controller;

import java.io.*;

public class DealFile {
    private static File file;

    public static void main(String[] args) throws IOException {
        file = new File("D:\\workspace_Idea\\SpringBootSourceCode\\Jpa\\src\\main\\resources");
        readFileController(file);
    }

    private static void readFileController(File file) throws IOException {
        if (file.isDirectory()) {
            String[] files = file.list();
            for (String fileName : files) {
                File f = new File(file + "\\" + fileName);
                if (f.isDirectory()) {
                    readFileController(f);
                } else {
                    readFileService(f);
                }
            }
        } else {
            readFileService(file);
        }

    }

    private static void readFileService(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(file.getCanonicalFile() + "\\sunText.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "utf-8"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        String readLine = "";
        while ((readLine = bufferedReader.readLine()) != null) {
            bufferedWriter.write(readLine);
        }
        if (readLine == null) {
            bufferedWriter.write("/n ------------该文件读取完毕----------/n" + f);
        }
        bufferedReader.close();
        bufferedWriter.close();
        fis.close();
        fos.close();
    }

}
