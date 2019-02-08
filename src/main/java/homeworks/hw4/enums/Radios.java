package homeworks.hw4.enums;

public enum Radios {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    private String value;

    Radios(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
