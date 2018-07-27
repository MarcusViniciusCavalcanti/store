package br.com.mundial.store.warehouse.structure.erros;

import br.com.mundial.store.warehouse.structure.erros.exceptions.DeletingOperationIllegalException;
import br.com.mundial.store.warehouse.structure.erros.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorsDetails resource_not_found = ErrorsDetails.Builder.newBuilder()
                .withTimestamp(LocalDateTime.now())
                .withTitle("Resource Not Found")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withDetail(exception.getMessage())
                .withDeveloperMessage("throw exception: " + exception.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(resource_not_found, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeletingOperationIllegalException.class)
    public ResponseEntity<?> handlerDeletingOperationIllegalException(DeletingOperationIllegalException exception) {
        ErrorsDetails resource_not_found = ErrorsDetails.Builder.newBuilder()
                .withTimestamp(LocalDateTime.now())
                .withTitle("Operation Illegal")
                .withStatus(HttpStatus.BAD_REQUEST.value())
                .withDetail(exception.getMessage())
                .withDeveloperMessage("throw exception: " + exception.getClass().getSimpleName())
                .build();

        return new ResponseEntity<>(resource_not_found, HttpStatus.BAD_REQUEST);
    }
}
