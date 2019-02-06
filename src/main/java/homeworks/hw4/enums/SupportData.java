package homeworks.hw4.enums;

public enum SupportData {
    TITLE("Different Elements"),

    FIRST_CHECKBOXES("Water"),
    SECOND_CHECKBOXES("Earth"),
    THIRD_CHECKBOXES("Wind"),
    FOURTH_CHECKBOXES("Fire"),

    FIRST_RADIO("Gold"),
    SECOND_RADIO("Silver"),
    THIRD_RADIO("Bronze"),
    FOURTH_RADIO("Selen"),

    FIRST_DROPDOWN("Red"),
    SECOND_DROPDOWN("Green"),
    THIRD_DROPDOWN("Blue"),
    FOURTH_DROPDOWN("Yellow");


    private String value;

    SupportData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
