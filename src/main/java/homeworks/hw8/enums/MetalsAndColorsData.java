package homeworks.hw8.enums;

public enum MetalsAndColorsData {
    METALS_TEXT("METALS & COLORS"),
    TITLE("Metal and Colors");

    private String value;

    MetalsAndColorsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
