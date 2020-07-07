package com.cars24.auction.demo.api;

import com.cars24.auction.demo.exception.SellerNotFoundException;
import com.cars24.auction.demo.model.*;
import com.cars24.auction.demo.repo.CarRepository;
import com.cars24.auction.demo.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller/{id}")
public class SellerController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping
    @RequestMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Car> listCars(@RequestBody List<Car> cars) {
        return (List<Car>) carRepository.saveAll(cars);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Seller findSeller(@PathVariable long sellerId){
        return sellerRepository.findById(sellerId)
                        .orElseThrow(SellerNotFoundException::new);
    }

    @GetMapping
    @RequestMapping("/car/{id}/auctionstate")
    @ResponseStatus(HttpStatus.OK)
    public AuctionState viewAuctionStateOfCar(@PathVariable long sellerId, @PathVariable long carId){
        Car car = carRepository.findBySellerIdAndId(sellerId, carId);
        List<Auction> auctions = car.getAuctions();
        for (Auction auction : auctions) {
            if(auction.getEndTime() == null){
                return AuctionState.STARTED;
            } else {
                return AuctionState.STOPPED;
            }
        }
        return AuctionState.SUSPENDED;
    }

    @GetMapping
    @RequestMapping("/car/{id}/price")
    @ResponseStatus(HttpStatus.OK)
    public double viewSalesPriceOfCar(@PathVariable long sellerId, @PathVariable long carId) {
        Car car = carRepository.findBySellerIdAndId(sellerId, carId);
        List<Auction> auctions = car.getAuctions();
        for (Auction auction : auctions) {
            if(auction.getEndTime() != null){
                List<Bid> bids = car.getBids();
                double price = bids.get(0).getBidAmount();
                for (Bid bid : bids) {
                    if(bid.getBidAmount() > price){
                        price = bid.getBidAmount();
                    }
                }
                return price;
            }
        }
        return 0;
    }

}
