package com.workshop.rest.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Integer> {
}
