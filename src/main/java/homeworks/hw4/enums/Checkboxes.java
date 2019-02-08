package homeworks.hw4.enums;

public enum Checkboxes {
    WATER("Water"),
    Earth("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String value;

    Checkboxes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
