package base.jdi.entities;

public class User {

    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");
    public String login;
    public String password;
    public String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }


}
