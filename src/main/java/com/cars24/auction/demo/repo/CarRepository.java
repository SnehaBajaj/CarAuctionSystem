package com.cars24.auction.demo.repo;

import com.cars24.auction.demo.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findBySellerId(long sellerId);
    Car findBySellerIdAndId(long sellerId, long id);
}
