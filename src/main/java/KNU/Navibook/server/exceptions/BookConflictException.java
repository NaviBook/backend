package KNU.Navibook.server.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BookConflictException extends RuntimeException {
    public BookConflictException(String message){
        super(message);
    }

}