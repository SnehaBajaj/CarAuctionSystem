package com.cars24.auction.demo.api;

import com.cars24.auction.demo.exception.BuyerNotFoundException;
import com.cars24.auction.demo.exception.CarNotFoundException;
import com.cars24.auction.demo.model.Auction;
import com.cars24.auction.demo.model.Bid;
import com.cars24.auction.demo.model.Buyer;
import com.cars24.auction.demo.model.Car;
import com.cars24.auction.demo.repo.BuyerRepository;
import com.cars24.auction.demo.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/buyer/{id}")
public class BuyerController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @GetMapping
    @RequestMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> viewAllCars(){
        List<Car> cars = (List<Car>) carRepository.findAll();
        List<Car> carsToShow = new ArrayList<>();
        for(Car car: cars) {
            List<Auction> auctions = car.getAuctions();
            for (Auction auction : auctions) {
                Calendar cal = Calendar.getInstance();
                cal.set(1900, Calendar.DECEMBER, 12);
                Date funnyTime = cal.getTime();
                if (!auction.getEndTime().equals(funnyTime)) {
                    carsToShow.add(car);
                }
            }
        }
        return carsToShow;
    }

    @PutMapping
    @RequestMapping("/car/{id}/bid/{amount}")
    @ResponseStatus(HttpStatus.CREATED)
    public Bid placeBid(@PathVariable long buyerId, @PathVariable long carId, @PathVariable double amount){
        Car car = carRepository.findById(carId).orElseThrow(CarNotFoundException::new);
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(BuyerNotFoundException::new);
        Bid bid = new Bid(buyer, car, amount);
        car.getBids().add(bid);
        return bid;
    }

    @GetMapping
    @RequestMapping("/car/{id}/bids")
    @ResponseStatus(HttpStatus.OK)
    public List<Bid> viewBidHistoryOfCar(@PathVariable long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(CarNotFoundException::new);
        return car.getBids();
    }
}
