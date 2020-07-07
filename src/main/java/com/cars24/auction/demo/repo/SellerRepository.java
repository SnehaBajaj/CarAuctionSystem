package com.cars24.auction.demo.repo;

import com.cars24.auction.demo.model.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {

}
