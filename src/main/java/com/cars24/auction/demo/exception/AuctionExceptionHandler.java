package com.cars24.auction.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AuctionExceptionHandler {

    @ExceptionHandler({AuctionNotFoundException.class,
            BuyerNotFoundException.class,
            CarNotFoundException.class,
            SellerNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected void handleNotFound(Exception ex, WebRequest request) {
    }
}
