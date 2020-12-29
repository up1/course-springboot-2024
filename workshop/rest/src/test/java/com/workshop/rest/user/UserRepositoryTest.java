package com.workshop.rest.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers() {
        // Initial data
        userRepository.save(new User("user 01", 10));
        userRepository.save(new User("user 02", 20));
        userRepository.save(new User("user 03", 30));

        // Act
        List<User> users = userRepository.findAllUsers();

        // Assert
        assertEquals(3, users.size());
        assertEquals(3, users.get(0).getId());
    }
}