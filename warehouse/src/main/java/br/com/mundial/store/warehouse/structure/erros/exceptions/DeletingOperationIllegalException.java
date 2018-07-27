package br.com.mundial.store.warehouse.structure.erros.exceptions;

public class DeletingOperationIllegalException extends IllegalArgumentException {
    public DeletingOperationIllegalException(Class<?> cls, Object id) {
        super("Not be possible deleting resource: " + cls.getSimpleName() + " for id: " + id + " because violation integrity" );
    }

    public DeletingOperationIllegalException(String message, Throwable cause) {
        super(message, cause);
    }
}
