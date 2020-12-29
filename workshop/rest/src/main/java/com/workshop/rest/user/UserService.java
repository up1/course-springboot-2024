package com.workshop.rest.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserModel inquiryUserById(int id) {
        return new UserModel(id, "demo", 30);
    }
}
