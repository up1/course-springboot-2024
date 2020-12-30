package com.workshop.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel inquiryUserById(int id) {
        User foundUser = userRepository.getOne(id);
        return new UserModel(id,
                foundUser.getName(), foundUser.getAge());
    }
}
