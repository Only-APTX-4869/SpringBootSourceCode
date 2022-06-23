package com.czh.controller;

import java.io.File;
import java.io.IOException;
//删除 项目下的xxx目录

public class DelTarget {
    public static void main(String[] args) throws IOException {
        File file = new File("");
        findTarget(file.getCanonicalPath());
    }

    //找到target目录地址 并返回
    public static void findTarget(String path){
        File file = new File(path);
        String[] files = file.list();
            for (String fileName : files) { //第一级目录
                file = new File(path + "\\" + fileName);
                if (file.isDirectory() && !file.getName().startsWith(".")) { // 第一级目录的文件夹
                    files = file.list();// 第二层目录，找目标目录

                    for (String fileNames : files) {
                        if ("target".equals(fileNames)) {
                            delFloder(file + "\\" + fileNames);
                            System.out.println("已删除:"+file+"\\"+fileNames);
                            continue;
                        }
                    }
                }
            }
    }
    /**
     * 删除文件夹
     *
     * @param floderPath
     */
    public static void delFloder(String floderPath) {
        try {
            delFile(floderPath); //删除文件
            java.io.File myFilePath = new java.io.File(floderPath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除文件
     * @param path
     */
    public static void delFile(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        File temp = null;
        for (int i = 0; i < fileName.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + fileName[i]); // 递归获取 指定目录下全部文件
            } else {
                temp = new File(path + File.separator + fileName[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delFile(path + "/" + fileName[i]);
                delFloder(path + "/" + fileName[i]);
            }
        }
    }
}
