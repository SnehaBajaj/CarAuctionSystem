package com.cars24.auction.demo.repo;

import com.cars24.auction.demo.model.Buyer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends CrudRepository<Buyer, Long> {
}
