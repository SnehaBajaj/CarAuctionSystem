package com.cars24.auction.demo.api;

import com.cars24.auction.demo.exception.CarNotFoundException;
import com.cars24.auction.demo.model.Bid;
import com.cars24.auction.demo.model.Car;
import com.cars24.auction.demo.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    @RequestMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> viewCars() {
        return (List<Car>) carRepository.findAll();
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
