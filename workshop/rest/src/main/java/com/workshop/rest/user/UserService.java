package com.workshop.rest.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel inquiryUserById(int id) {
        try {
            User foundUser = userRepository.getOne(id);
            return new UserModel(id,
                    foundUser.getName(), foundUser.getAge());
        }catch (Exception e) {
            throw new UserNotFoundException(id);
        }
    }

    public UserModel create(UserModel userModel) {
        User newUser = new User(userModel.getName(), userModel.getAge());
        newUser = userRepository.save(newUser);
        return new UserModel(newUser.getId(),
                newUser.getName(),
                newUser.getAge());
    }
}
