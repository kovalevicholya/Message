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
