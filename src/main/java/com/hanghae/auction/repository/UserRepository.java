package com.hanghae.auction.repository;

import com.hanghae.auction.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
