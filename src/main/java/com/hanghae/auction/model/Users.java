package com.hanghae.auction.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
