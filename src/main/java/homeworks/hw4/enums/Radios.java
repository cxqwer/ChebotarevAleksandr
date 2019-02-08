package homeworks.hw4.enums;

// TODO This is the Metals, c'mon man
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
