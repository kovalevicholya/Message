package message;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private final String name;
    private final String password;
    private  long id;

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

    public void setId(long id) {
        this.id=id;
    }

    @Override
    public String toString() {
        return "User{"+
                "name='"+name+'\''+
                ", password='"+password+'\''+
                ", id="+id+
                '}';
    }
}
