package lables;

public enum IOSLABEL {
    DUMMYVALUE("DummyValue");
    String value;
    public String getValue() {
        return value;
    }

    IOSLABEL(String v){
        value = v;
    }
}
