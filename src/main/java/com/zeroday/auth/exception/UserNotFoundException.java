package com.zeroday.auth.exception;

public class UserNotFoundException extends Exception{
    private String username;
    public UserNotFoundException(String username) {
        super(String.format("Author is not found with id : '%s'", username));
    }
}
