package com.cars24.auction.demo.api;

import com.cars24.auction.demo.exception.AuctionNotFoundException;
import com.cars24.auction.demo.model.Auction;
import com.cars24.auction.demo.repo.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    AuctionRepository auctionRepository;

    @GetMapping("/{id}")
    public Auction findAuction(@PathVariable Long auctionId) {
        return auctionRepository.findById(auctionId)
                .orElseThrow(AuctionNotFoundException::new);
    }

    @PutMapping
    @RequestMapping("/{id}/start")
    @ResponseStatus(HttpStatus.OK)
    public Auction startAuction(@RequestBody Auction auction){
        // TODO: create new auction here with list of car IDs, system time as start time, null as end time
        // and save it to repo
        return auctionRepository.save(auction);
    }

    @PutMapping
    @RequestMapping("/{id}/stop")
    @ResponseStatus(HttpStatus.OK)
    public Auction stopAuction(@RequestBody Auction auction){
        // TODO: take auction ID only as path variable and save system time as end time
        return auctionRepository.save(auction);
    }

    @PutMapping
    @RequestMapping("/{id}/suspend")
    @ResponseStatus(HttpStatus.OK)
    public Auction suspendAuction(@RequestBody Auction auction){
        // TODO: take auction ID only as path variable and save system time as 0 to mark auction suspended
        return auctionRepository.save(auction);
    }

}
