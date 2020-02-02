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

