package message;

import java.io.*;

public class MessageMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

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

        FileOutputStream fileOutputStream = new FileOutputStream("file");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user1);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("file");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(newUser);

    }
}
