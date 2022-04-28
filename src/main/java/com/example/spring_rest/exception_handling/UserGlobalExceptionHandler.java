package com.example.spring_rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// Аннотацией @ControllerAdvice отмечается класс, предоставляющий функциональность Global Exception Handler-а
public class UserGlobalExceptionHandler {

    // Возвращает JSON, когда выбрасывается NoSuchUserException. Этот метод, ответственный за обработку исключений
    // ResponseEntity - это обёртка Http response
    // UserIncorrectData - тип объекта, который добавляется в HTTP response body
    // NoSuchUserException - exception, на который должен реагировать данный метод
    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(NoSuchUserException exception) {
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserIncorrectData> handleException(Exception exception) {
        UserIncorrectData data = new UserIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}