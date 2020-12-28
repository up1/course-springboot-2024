package com.workshop.day2.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            userResponseList.add(new UserResponse(user.getId(),
                    user.getName(), user.getAge()));
        }
        return userResponseList;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException(id))
        UserResponse userResponse = new UserResponse(user.getId(),
                user.getName(), user.getAge());
        return userResponse;
    }

    @PostMapping("/users")
    public UserResponse createNewUser(@RequestBody UserRequest newUser) {
        UserResponse newUserResponse = new UserResponse(
                1,
                newUser.getName(),
                newUser.getAge());
        return newUserResponse;
    }

    @PutMapping("/users/{id}")
    public UserResponse updateUser(@RequestBody UserRequest newUser, @PathVariable int id) {
        return userRepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setAge(newUser.getAge());
            userRepository.save(user);

            UserResponse updatedUserResponse = new UserResponse(
                    id,
                    newUser.getName(),
                    newUser.getAge());
            return updatedUserResponse;
        }).orElseGet(() -> {
            User user = new User();
            user.setId(id);
            user = userRepository.save(user);

            UserResponse updatedUserResponse = new UserResponse(
                    user.getId(),
                    user.getName(),
                    user.getAge());
            return updatedUserResponse;
        });
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        // TODO
    }

}
