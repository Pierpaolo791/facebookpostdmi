package com.facebookpostdmi.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YmlResolver {

    private static final Yaml yml = new Yaml();;
    private static final String PATH = "../settings.yml";

    private YmlResolver() {
    }

    private static FileInputStream getInputStream() {
        try {
            return new FileInputStream(PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Map<String, Object> getMap() {
    	FileInputStream fileStream = getInputStream();
    	Map<String,Object> map = yml.load(fileStream);
    	try {
			fileStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return map;
        
    }

    public static String getValue(String key) {
        return (String) getMap().get(key);
    }
    
}
