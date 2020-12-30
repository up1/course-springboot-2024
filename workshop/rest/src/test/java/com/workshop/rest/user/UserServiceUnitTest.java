package com.workshop.rest.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void userNotFound() {
        UserService userService = new UserService(userRepository);
        try {
            userService.inquiryUserById(1);
            fail("Not found exception");
        }catch (UserNotFoundException e) {
            // Pass
        }

        Assertions.assertThrows(RuntimeException.class, () -> {
            userService.inquiryUserById(1);
        });
    }
}