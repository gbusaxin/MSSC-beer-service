package com.gbusaxin.msscbeerservice.repositories;

import com.gbusaxin.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @created : by GBu on 27. 10. 2022, štvrtok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
