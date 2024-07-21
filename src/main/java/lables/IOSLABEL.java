package lables;

public enum IOSLABEL {
    MESSAGE("A message should be a short, complete sentence.");
    String value;
    public String getValue() {
        return value;
    }

    IOSLABEL(String v){
        value = v;
    }
}
