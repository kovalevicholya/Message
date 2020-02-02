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
