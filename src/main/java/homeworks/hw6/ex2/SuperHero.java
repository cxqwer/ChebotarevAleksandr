package homeworks.hw6.ex2;

public class SuperHero {
    private String number;
    private String user;
    private String desciption;

    SuperHero(String numberType, String user, String description) {
        this.number = numberType;
        this.user = user;
        this.desciption = description;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDesciption() {
        return desciption;
    }
}

