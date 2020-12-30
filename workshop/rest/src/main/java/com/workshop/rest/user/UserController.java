package com.workshop.rest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/user2/{id}")
    public ResponseEntity<UserResponse> getUser2(@PathVariable int id) {
        // Call service
        try {
            UserModel user = userService.inquiryUserById(id);
            // Mapping to response
            UserResponse userResponse
                    = new UserResponse(id, user.getName(), user.getAge());
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(new UserResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user") //user?page=1
    public UserListResponse getAllUser(
            @RequestParam(defaultValue = "1") int page) {
        return new UserListResponse(
                new UserResponse(1, "demo 1", 30),
                new UserResponse(2, "demo 2", 35)
        );
    }


}
