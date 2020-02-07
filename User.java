package message;

import java.io.*;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String password;
    private long id;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
        out.writeLong(id);
        out.writeObject(password);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        id = in.readLong();
        password = (String) in.readObject();

    }
    private void readObjectNoData(ObjectInputStream in) throws ObjectStreamException{

    }
}
