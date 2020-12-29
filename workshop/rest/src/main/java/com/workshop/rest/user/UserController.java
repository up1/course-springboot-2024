package com.workshop.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        // Call service
        UserModel user = userService.inquiryUserById(id);
        // Mapping to response
        UserResponse userResponse
                = new UserResponse(id, user.getName(), user.getAge());
        return userResponse;

    }

    @GetMapping("/user") //user?page=1
    public UserListResponse getAllUser(
            @RequestParam(defaultValue = "1") int page) {
        return new UserListResponse(
                new UserResponse(1, "demo 1", 30),
                new UserResponse(2, "demo 2", 35)
        );
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user2") //user?page=1
    public UserListResponse getAllUser2(
            @RequestParam(defaultValue = "1") int page) {
        List<User> users = userRepository.findAll();
        UserListResponse userListResponse = new UserListResponse();
        for (User user : users) {
            userListResponse.add(new UserResponse());
        }
        return userListResponse;
    }


}
