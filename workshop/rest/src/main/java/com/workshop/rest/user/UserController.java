package com.workshop.rest.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user") //user?page=1
    public List<UserResponse> getAllUser(
            @RequestParam(defaultValue = "1") int page) {
        List<UserResponse> userResponseList = new ArrayList<>();
        userResponseList.add(new UserResponse(1, "demo 1", 30));
        userResponseList.add(new UserResponse(2, "demo 2", 35));
        return userResponseList;
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        UserResponse userResponse = new UserResponse(id, "demo", 30);
        return userResponse;
    }


}
