package com.cars24.auction.demo.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Buyer extends User {

    @OneToMany(mappedBy = "buyer")
    List<Bid> bids;

    public Buyer(String name, String username, String password, String email, String phoneNumber, UserType userType, List<Bid> bids) {
        super(name, username, password, email, phoneNumber, userType);
        this.bids = bids;
    }
}
