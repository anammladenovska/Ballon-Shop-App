package mk.ukim.finki.wp.lab.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Password do not match exception");
    }
}
