package com.workshop.rest.user;

import com.workshop.rest.post.PostGateway;
import com.workshop.rest.post.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostGateway postGateway;

    @GetMapping("/post/{id}")
    public PostResponse getPost(@PathVariable int id) {
        return postGateway.getPostById(id).get();
    }

    @PostMapping("/user")
    public UserResponse createNewUser(@RequestBody NewUserRequest newUserRequest) {
        UserModel newUser = userService.create(
                new UserModel(newUserRequest.getName(),
                        newUserRequest.getAge()));
        return new UserResponse(
                newUser.getId(), newUser.getName(), newUser.getAge());
    }

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
        List<UserModel> userModels = userService.getAll();
        UserListResponse userListResponse = new UserListResponse();
        userModels.forEach(u -> userListResponse.add(
                new UserResponse(u.getId(), u.getName(), u.getAge())));

//        userModels.stream()
//                .filter(user -> user.getId() % 2 == 0)
//                .distinct()
//                .sorted();
        return userListResponse;
    }


}
