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
