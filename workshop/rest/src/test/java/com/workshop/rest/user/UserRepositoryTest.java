package com.workshop.rest.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getDataById() {
        // Arrange
        User user1 = new User("Name test", 50);
        userRepository.save(user1);
        // Act
        User user = userRepository.getOne(1);
        // Assert
        assertEquals(1, user.getId());
        assertEquals("Name test", user.getName());
        assertEquals(50, user.getAge());
    }

}