package com.gbusaxin.msscbeerservice.web.controller;

import com.gbusaxin.msscbeerservice.web.model.BeerDto;
import com.gbusaxin.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    private ResponseEntity<BeerDto> getBeerById(@PathVariable(name = "beerId") UUID id) {
        return new ResponseEntity<>(getBeerDtoPlaceholder(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity<>(getBeerDtoPlaceholder(), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<Void> updateBeer(@PathVariable(name = "beerId") UUID id, @RequestBody @Validated BeerDto beerDto) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    BeerDto getBeerDtoPlaceholder() {
        return BeerDto.builder()
                .beerName("Baltika")
                .beerStyle(BeerStyleEnum.IPA)
                .price(new BigDecimal("12.12"))
                .upc(13231212L)
                .build();
    }
}
