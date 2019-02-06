package homeworks.hw4.enums;

public enum SliderData {
    TITLE("Dates"),
    ZERO("0"),
    HUNDRED("100"),
    THIRTY("30"),
    SEVENTY("70");


    private String value;

    SliderData(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
