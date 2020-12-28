package com.workshop.day2.users;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("Could not find user " + id);
    }
}
