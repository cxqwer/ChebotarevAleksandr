package homeworks.hw8.enums;

public enum HeaderElements {

    HOME("HOME"),
    CONTACT ("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    private String value;
    HeaderElements(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
