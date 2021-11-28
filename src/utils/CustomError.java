package utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomError {
    Integer status;
    String timestamp;
    String error;
    String code;
    String message;
}