package homeworks.hw4.enums;

public enum NatureElements {
    WATER("Water"),
    Earth("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    private String value;

    NatureElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
