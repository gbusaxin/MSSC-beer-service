package com.gbusaxin.msscbeerservice.bootstrap;

import com.gbusaxin.msscbeerservice.domain.Beer;
import com.gbusaxin.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {
        if (beerRepository.count() == 0) {
            log.info("Start loading beers content");
            for (int i = 1; i< 15; i++){
                beerRepository.save(Beer.builder()
                        .beerName("Baltika " + i)
                        .beerStyle("IPA")
                        .quantityToBrew(200 + i)
                        .minOnHand(12 + i)
                        .upc(Long.getLong(String.valueOf(4234141421L + i)))
                        .price(new BigDecimal("135.0"))
                        .build());
            }
        }
        log.info("Beers content has been loaded: " + beerRepository.count());
    }

}
