package com.workshop.day2.users;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList = new ArrayList<>();
        userResponseList.add(new UserResponse(1,"demo 1", 30));
        userResponseList.add(new UserResponse(2,"demo 2", 35));
        return userResponseList;
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable int id) {
        UserResponse userResponse = new UserResponse(id, "Demo", 40);
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
        // TODO
        // 1. find by id
        // 2. found => update user
        // 3. not found => ?? (create ? or throw error)
        UserResponse updatedUserResponse = new UserResponse(
                id,
                newUser.getName(),
                newUser.getAge());
        return updatedUserResponse;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        // TODO
    }

}
