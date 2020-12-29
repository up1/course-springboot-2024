package com.workshop.rest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT user FROM User user ORDER BY user.id DESC")
    @Transactional(readOnly = true)
    List<User> findAllUsers();

}
