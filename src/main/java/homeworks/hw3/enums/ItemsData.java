package homeworks.hw3.enums;

public enum ItemsData {
    FIRST_ITEMS_TEXT("HOME"),
    SECOND_ITEMS_TEXT("CONTACT FORM"),
    THIRD_ITEMS_TEXT("SERVICE"),
    FOURTH_ITEMS_TEXT("METALS & COLORS");

    private String value;

    ItemsData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
