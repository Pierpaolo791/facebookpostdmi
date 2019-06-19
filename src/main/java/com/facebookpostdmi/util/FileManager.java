package com.facebookpostdmi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {
    
    private static final String PATH = YmlResolver.getValue("file");
    
    public static String read() {
        try {
            return new String(Files.readAllBytes(Paths.get(PATH)));
        } catch (IOException ex) {
            try {
                Files.write(Paths.get(PATH), "".getBytes(), StandardOpenOption.CREATE);
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
            ex.printStackTrace();
        }
        return null;
    }
    public static void write(String str) {
        try {
            Files.write(Paths.get(PATH), "\n".concat(str).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean isContains(String url) {
    	return read().contains(url);
    }
}
