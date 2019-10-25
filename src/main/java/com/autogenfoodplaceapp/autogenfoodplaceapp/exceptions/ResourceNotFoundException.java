package com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ResourceNotFoundException";
    }
}
