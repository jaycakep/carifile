/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.giantrj.CariFile.handler.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetFiles {

    public GetFiles() {
    }

    public List<File> scrapFiles(String path) {
        File directory = new File(path);
        List<File> fileInfo = new ArrayList<>();

        try {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileInfo.add(file);
                    } else if (file.isDirectory()) {
                        fileInfo.addAll(scrapFiles(file.getAbsolutePath()));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return fileInfo;
    }
}

