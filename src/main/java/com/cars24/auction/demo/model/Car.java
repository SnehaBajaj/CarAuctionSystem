package com.cars24.auction.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String make;

    @Column
    String model;

    @Column
    int year;

    @Column
    float kmsDriven;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    Seller seller;

    @ManyToMany(mappedBy = "cars")
    List<Auction> auctions;

    @OneToMany(mappedBy = "car")
    List<Bid> bids;

    public Car(String make, String model, int year, float kmsDriven) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kmsDriven = kmsDriven;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(float kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
