package utils;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

// To read the testdata from json file

public class TestdataReader {
    public static String value = " ";
    private static String platform;

    //    To read testdata
    public static String readTestdata(String platformName, String key) {
        JsonParser jsonparser = new JsonParser();
        ConfigReader configReader = new ConfigReader();
        try {
            platform = configReader.getValueAsString("platform");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String envBasedTestDataFile = "/src/test/resources/" + platform + "Testdata.json";
        try {
            Object obj = jsonparser.parse(new FileReader((System.getProperty("user.dir") + envBasedTestDataFile)));
            JsonObject jsonObject = (JsonObject) obj;
            JsonArray data = (JsonArray) jsonObject.get(platform);
            for (int i = 0; i < data.size(); i++) {
                JsonObject users = (JsonObject) data.get(i);
                value = String.valueOf(users.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value.replaceAll("\"", "");
    }

    public static String[] readMultipleTestdata(String country, String key) {
        String [] a = new String[0];
        JsonParser jsonparser = new JsonParser();
        ConfigReader configReader = new ConfigReader();
        try {
            platform = configReader.getValueAsString("platform");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String envBasedTestDataFile = "/src/test/resources/" + platform + "Testdata.json";
        Object obj = null;
        try {
            obj = jsonparser.parse(new FileReader((System.getProperty("user.dir") + envBasedTestDataFile)));
            JsonObject jsonObject = (JsonObject) obj;
            JsonArray data = (JsonArray) jsonObject.get(country);
            for (int i = 0; i < data.size(); i++) {
                JsonObject users = (JsonObject) data.get(i);
                value = String.valueOf(users.get(key));
            }
            String[] res = value.split("[,]", 0);
            String[] multipleDatas = new String[res.length];
            for(int i = 0; i < res.length; i++){
                multipleDatas[i]=res[i].replaceAll("\"", "");;
            }
            return multipleDatas;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }
}
