package com.workshop.rest.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User not found with user id=" + id);
    }
}
