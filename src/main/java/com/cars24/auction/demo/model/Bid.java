package com.cars24.auction.demo.model;

import javax.persistence.*;

@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    Auction auction;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    @Column
    Double bidAmount;

    public Bid(Buyer buyer, Car car, Double bidAmount) {
        this.buyer = buyer;
        this.car = car;
        this.bidAmount = bidAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }
}
