package message;

import java.util.HashMap;
import java.util.Map;


public class Registration {
    Map<String, String> user = new HashMap<>();
    Validation validation = new Validation();
    public void reg(String name, String pass){
        if((user.containsKey(name)))
            System.out.println("Такое имя уже существует");
        else {
            user.put(name, pass);
            validation.valid(pass);
        }

    }
}
