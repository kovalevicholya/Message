package message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Chat {
    private final Set<User> saveUser = new HashSet<>();
    private final List<Message> saveMessage = new ArrayList<>();





    public void addMessage(Message message) throws IllegalAccessException {
        if (!MessageType.TEXT.equals(message.getType())) {
            throw new IllegalAccessException("Сообщение должно быть текстовым");
        }
         else
             saveMessage.add(message);

    }
    public void addMessage (Message[] message) {
        this.addMessage(message);
        for (int i = 0; i<message.length;i++) {
            saveMessage.add(message[i]);
        }
    }

}
