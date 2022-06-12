package com.hanghae.auction.repository;

import com.hanghae.auction.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);

    //username 중복확인
    boolean existsByUsername(String username);
}
