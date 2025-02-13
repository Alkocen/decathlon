package ee.martin.decathlon.exceptions;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleDatabaseErrors(DataIntegrityViolationException e) {
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(new Date());
        message.setCode(400);
        message.setMessage("Database constraint violation: " + e.getMessage());

        return ResponseEntity.badRequest().body(message);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(RuntimeException e) {
        ErrorMessage message = new ErrorMessage();
        message.setTimestamp(new Date());
        message.setCode(400);
        message.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(message);
    }
}
