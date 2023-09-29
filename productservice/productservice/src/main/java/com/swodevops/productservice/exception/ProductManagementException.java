package com.swodevops.productservice.exception;

public class ProductManagementException extends RuntimeException {

    public ProductManagementException(String message) {
        super(message);
    }

    public ProductManagementException(String message, Throwable cause) {
        super(message, cause);
    }
}
