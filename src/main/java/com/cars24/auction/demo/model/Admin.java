package com.cars24.auction.demo.model;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin(String name, String username, String password, String email, String phoneNumber, UserType userType) {
        super(name, username, password, email, phoneNumber, userType);
    }
}
