package br.com.mundial.store.warehouse.structure.erros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> cls, Object id) {
        super("Resource " + cls.getSimpleName() + "not found for this id: " + id);
    }
}
