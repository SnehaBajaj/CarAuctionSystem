package com.cars24.auction.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seller extends User {

    @OneToMany(
            mappedBy = "seller",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Car> cars = new ArrayList<>();

    public Seller(String name, String username, String password, String email, String phoneNumber, UserType userType, List<Car> cars) {
        super(name, username, password, email, phoneNumber, userType);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "cars=" + cars +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", userType=" + userType +
                '}';
    }
}
