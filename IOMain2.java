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
