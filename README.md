# Messagepackage message;

public enum MessageType {
    TEXT,
    VIDEO,
    STICER,
    FILE

}

package message;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class MessageWriter implements ISaverChat {
    public void save(Chat chat) {
        List<? extends Message> messages=chat.getSaveMessage();

        try {
            Writer writer=new PrintWriter(new FileOutputStream("message_text.txt"));
            for (Message message : messages)
                ((PrintWriter) writer).println(chat);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}


package message;

import java.util.HashMap;
import java.util.Map;


public class Registration {
    Map<String, String> user = new HashMap<>();
    Validation validation = new Validation();

    public void reg(User users){
        if((user.containsKey(users.getName())))
            System.out.println("Такое имя уже существует");
        else {
            user.put(users.getName(), users.getPassword());
            validation.valid(users.getPassword());
            users.setId(users.getId()+user.size());
        }
    }
}

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

package message;

public class Validation {
    public boolean valid (String pass){
        boolean result = pass.matches("[a-zA-Z0-9]{7,}[:/!&+%]{1,3}");
        if(result == true){
            System.out.println("Вы зарегестрированы");
        }
        else{
            System.out.println("Пороль не соответствует правилам");
        }

        return result;
    }
}

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
        out.writeObject(getSaveUser());
    }
    private void readeObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        in.readObject();

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



package message;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOMain2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User u = new User("hg", "hgc", 564654);
        users.add(u);
        try(OutputStream stream = new FileOutputStream("file_text.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {
             //objectOutputStream.writeObject(u);
            objectOutputStream.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package message;

public interface ISaverChat {
    public void save(Chat chat);
}

package message;

import java.util.Date;

public class Message<T> {
    private User user;
    private Date date;
    private MessageType type;
    private T data;

    public Message(User user) {
        this.user = user;
    }

    public Message(User user, Date date, MessageType type, T data) {
        this.user=user;
        this.date=date;
        this.type=type;
        this.data=data;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date=date;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type=type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data=data;
    }

    @Override
    public String toString() {
        return "Message{"+
                "user="+user+
                ", date="+date+
                ", type="+type+
                ", data="+data+
                '}';
    }
}

package message;


import java.util.List;

public class MessageIn implements ISaverChat {
    public void save(Chat chat) {
        List<? extends Message> messages=chat.getSaveMessage();
        if (messages != null) {
            for (Message message : messages) {
                System.out.println(message);
            }
        }
    }
}

package message;

import java.io.*;

public class MessageMain {
    public static void main(String[] args) throws IOException {

        Registration registration=new Registration();
        User user1=new User("Olga", "123456IO:", 1000000000);
        User user2=new User("Elena", "11456IO:", 1000000000);
        User user3=new User("Peter", "188559IO%", 1000000000);
        User user4=new User("Vera", "1889956IO/", 1000000000);
        registration.reg(user1);
        registration.reg(user2);
        registration.reg(user3);
        registration.reg(user4);
        Chat chat = new Chat();
        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);
        chat.addUser(user4);

        Message message = new Message(user1,null, MessageType.TEXT, "Привет Java");
        chat.addMessage(message);
        MessageIn messageIn = new MessageIn();
        messageIn.save(chat);
        MessageWriter messageWriter = new MessageWriter();
        messageWriter.save(chat);

        FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(chat);
        objectOutputStream.flush();
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream("file.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

    }
}
