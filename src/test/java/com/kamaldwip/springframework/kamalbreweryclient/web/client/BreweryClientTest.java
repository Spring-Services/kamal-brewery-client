package com.kamaldwip.springframework.kamalbreweryclient.web.client;

import com.kamaldwip.springframework.kamalbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {

        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);

    }
}