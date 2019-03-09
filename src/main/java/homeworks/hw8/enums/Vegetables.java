package homeworks.hw8.enums;

public enum Vegetables {
    TOMATO("Tomato"),
    ONION("Onion"),
    VEGETABLES("Vegetables"),
    CUCUMBER("Cucumber");
    private String value;

    Vegetables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
