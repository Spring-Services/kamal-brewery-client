package com.kamaldwip.springframework.kamalbreweryclient.web.client;

import com.kamaldwip.springframework.kamalbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("KingFisher").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());

    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("Heineken").build();
        client.updateBeer(UUID.randomUUID(),beerDto);

    }
}