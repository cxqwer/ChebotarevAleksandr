package homeworks.hw3.enums;

public enum Users {
    PETER("epam", "1234", "PETER CHAVLOWSKY");

    public final String login;
    public final String password;
    public final String name;

    Users(String login, String password, String name) {

        this.login = login;
        this.password = password;
        this.name = name;
    }

}
