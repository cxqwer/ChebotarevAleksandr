package homeworks.hw4.enums;

// TODO What kind of data ?
// TODO I think it will be better to separate this enum by some criteria...
public enum SupportData {
    TITLE("Different Elements"),

    // TODO Ho my, what is the reason of this naming style ?
    // TODO Why dont you name it like WATER, FIRE and so on ?
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
