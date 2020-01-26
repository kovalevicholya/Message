package message;

public class User {
    private final String name;
    private final String password;
    private final long id;

    public User(String name, String password, long id) {
        this.name=name;
        this.password=password;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }
}
