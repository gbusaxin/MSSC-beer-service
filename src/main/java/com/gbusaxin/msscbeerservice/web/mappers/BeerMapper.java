package com.gbusaxin.msscbeerservice.web.mappers;

import com.gbusaxin.msscbeerservice.domain.Beer;
import com.gbusaxin.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * @created : by GBu on 28. 10. 2022, piatok
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
