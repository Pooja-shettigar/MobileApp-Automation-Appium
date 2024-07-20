package lables;

public enum ANDROIDLABEL {
    Dropped("Dropped!"),
    SampleMenu("Sample menu"),
    WifiSettings("WiFi settings");

    String value;
    public String getValue() {
        return value;
    }

    ANDROIDLABEL(String v){
        value = v;
    }
}
