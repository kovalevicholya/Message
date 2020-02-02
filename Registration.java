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
