package mk.ukim.finki.wp.lab.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class BalloonAlreadyInShoppingCartException extends RuntimeException{

    public BalloonAlreadyInShoppingCartException(String username,Long id){
        super(String.format("Product with id: %d already exists in shopping cart for user with username %s", username, id));

    }

}
