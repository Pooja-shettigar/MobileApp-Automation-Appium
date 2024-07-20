package utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

// To read the configuration added in config.yaml file
public class ConfigReader {
    Map<String, Object> yamlMaps = new HashMap<>();
    Yaml yaml = new Yaml();


    //set capability
    public  DesiredCapabilities getConfigData() throws FileNotFoundException {
        Map<Map<Object, Object>, Object> capabilities = new HashMap<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.yaml");
        yamlMaps = (Map<String, Object>) yaml.load(inputStream);
        String platform = yamlMaps.get("platform").toString();
        capabilities = (HashMap<Map<Object, Object>, Object>) yamlMaps.get(platform);
        for (Object key : capabilities.keySet()) {
            if (key.equals("app")) {
                caps.setCapability(key.toString(), System.getProperty("user.dir") + capabilities.get(key).toString());
            } else {
                caps.setCapability(key.toString(), capabilities.get(key).toString());
            }
        }
        return caps;

    }


    //fetch platform name from yaml file
    public String getPlatformName() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.yaml");
        yamlMaps = (Map<String, Object>) yaml.load(inputStream);
        return yamlMaps.get("platform").toString();
    }

    public String getValueAsString(String key) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.yaml");
        yamlMaps = (Map<String, Object>) yaml.load(inputStream);
        return yamlMaps.get(key).toString();
    }

    //fetch port number from yaml file
    public String getPortNumber(String platformName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.yaml");
        yamlMaps = (Map<String, Object>) yaml.load(inputStream);
        String port_number;
        if (platformName.equalsIgnoreCase("android")) {
            port_number = yamlMaps.get("androidPort").toString();
        } else
            port_number = yamlMaps.get("iOSPort").toString();

        return port_number;
    }

    public String getBundleId() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.yaml");
        yamlMaps = (Map<String, Object>) yaml.load(inputStream);
        String bundle_id = yamlMaps.get("bundleId").toString();
        return bundle_id;
    }

    public void setEnvironmentInYaml(String environment) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ObjectNode root = (ObjectNode) mapper.readTree(new File(System.getProperty("user.dir") + "/config.yaml"));
        // Update the value
        root.put("environment", environment);
        // Write changes to the YAML file
        mapper.writer().writeValue(new File(System.getProperty("user.dir") + "/config.yaml"), root);
    }
}

