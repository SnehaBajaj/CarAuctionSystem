package com.cars24.auction.demo.repo;

import com.cars24.auction.demo.model.Auction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long>{
}
