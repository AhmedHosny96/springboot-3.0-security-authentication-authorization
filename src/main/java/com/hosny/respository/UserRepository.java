package com.hosny.respository;

import com.hosny.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User , Integer> {
    Optional<User> findByUsername(String username);
}
