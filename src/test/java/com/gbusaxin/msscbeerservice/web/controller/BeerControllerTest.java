package com.gbusaxin.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbusaxin.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
//@WebMvcTest(BeerController.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);
        mockMvc.perform(post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerToJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .content(beerToJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}