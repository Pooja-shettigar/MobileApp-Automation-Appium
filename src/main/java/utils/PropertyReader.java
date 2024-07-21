package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PropertyReader {
    private static Properties prop;
    public static HashMap<String, String> configPropertyMap;
    public static HashMap<String, String> testdataPropertyMap;
    public static HashMap<String, String> endpointPropertyMap;

    private void loadProps(String propertyFile) throws FileNotFoundException, IOException {
        File cfgfile = new File(propertyFile);
        if (cfgfile.exists()) {
            FileInputStream propin = new FileInputStream(cfgfile);
            prop.load(propin);
        }
    }

    public HashMap<String, String> getProperties(String propertyFilePath) throws FileNotFoundException, IOException {
        prop=new Properties();
        HashMap<String, String> map = new HashMap<String, String>();
        loadProps(propertyFilePath);
        Set<Object> keys = prop.keySet();
        for(Object k:keys){
            String key = (String)k;
            map.put(key, (String)prop.getProperty(key));
        }
        return map;
    }
}
