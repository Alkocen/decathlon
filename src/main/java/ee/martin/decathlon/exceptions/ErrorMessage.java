package ee.martin.decathlon.exceptions;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorMessage {
    private int Code;
    private Date timestamp;
    private String message;

}
