package com.cars24.auction.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    Date startTime;

    @Column
    Date endTime;

    @ManyToMany
    @JoinTable(
            name = "car_auction",
            joinColumns = @JoinColumn(name = "auction_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    List<Car> cars;

    @OneToMany(mappedBy = "auction")
    List<Bid> bids;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
