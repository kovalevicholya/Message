package message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Chat implements Serializable {
    private final Set<User> saveUser=new HashSet<>();
    private final List<Message> saveMessage=new ArrayList<>();

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }
    private void readeObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();


    }
    private void readeObjectNoData(Object o){}

    @Override
    public String toString() {
        return "Chat{"+
                "saveUser="+saveUser+
                ", saveMessage="+saveMessage+
                '}';
    }

    public Set<User> getSaveUser() {
        return saveUser;
    }

    public List<Message> getSaveMessage() {
        return saveMessage;
    }

    public void addMessage(Message message) {
        if (message != null) {
            saveMessage.add(message);
        }
    }

    public void addMessage(Message[] message) {
        if (message != null) {
            for (Message message1 : message) {
                this.addMessage(message1);
            }
        }
    }
    public void addMessage(List<Message> message) {
        if (message != null) {
            for (Message message1 : message) {
                this.addMessage(message1);
            }
        }
    }
    public void addUser(User user){
        if(user!=null)
            saveUser.add(user);
        System.out.println("В чате " + saveUser.size() + " участников");
    }
}


