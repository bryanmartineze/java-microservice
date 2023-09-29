package com.swodevops.productservice.exception;

public class ProductNotFoundException extends ProductManagementException {

    public ProductNotFoundException(Long id) {
        super("Product with ID " + id + " not found.");
    }
}