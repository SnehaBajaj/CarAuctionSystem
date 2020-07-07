package com.cars24.auction.demo;

import com.cars24.auction.demo.model.Car;
import com.cars24.auction.demo.model.Seller;
import com.cars24.auction.demo.model.UserType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AuctionApplication.class)
@TestPropertySource(value = {"classpath:application.properties"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AuctionApplicationTests {

    public static final String API_ROOT = RestAssured.DEFAULT_URI + ":" + RestAssured.DEFAULT_PORT;

    public Seller createSeller() {
        return new Seller("TestUser", "testUser",
                "testpwd", "testUser@testmail.com",
                "1234567890", UserType.SELLER, new ArrayList<>());
    }

    @Test
    public void whenCreateNewUser_thenCreated() {
        Seller seller = createSeller();
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(seller)
                .post(API_ROOT + "/seller");

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenListCars_thenOK() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("MakeSample", "ModelSample", 1982, 15000));
        int sellerId = 1;
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(carList)
                .post(API_ROOT + "/seller/" + sellerId + "/cars");

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void whenGetCars_thenOK() {
        long sellerId = 1;
        Seller testSeller = createSeller();
        testSeller.setCars(Collections.singletonList(new Car("MakeSample", "ModelSample", 1982, 15000)));
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .get(API_ROOT + "/seller/" + sellerId);

        System.out.println(response.getBody());
    }
}
