package com.cars24.auction.demo.api;

import com.cars24.auction.demo.model.Buyer;
import com.cars24.auction.demo.model.Seller;
import com.cars24.auction.demo.repo.BuyerRepository;
import com.cars24.auction.demo.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Registration {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @PostMapping
    @RequestMapping("/seller")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller createSeller(@RequestBody Seller seller){
        return sellerRepository.save(seller);
    }

    @PostMapping
    @RequestMapping("/buyer")
    @ResponseStatus(HttpStatus.CREATED)
    public Buyer createBuyer(@RequestBody Buyer buyer){
        return buyerRepository.save(buyer);
    }

}
