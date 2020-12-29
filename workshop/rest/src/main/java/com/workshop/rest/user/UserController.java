package com.workshop.rest.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user") //user?page=1
    public UserListResponse getAllUser(
            @RequestParam(defaultValue = "1") int page) {
        return new UserListResponse(
                new UserResponse(1, "demo 1", 30),
                new UserResponse(2, "demo 2", 35)
        );
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        UserResponse userResponse = new UserResponse(id, "demo", 30);
        return userResponse;
    }


}
