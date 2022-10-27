package com.gbusaxin.msscbeerservice.web.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @created : by GBu on 26. 10. 2022, streda
 * @mailto : grigorii.busakhin@software-foundation.sk
 **/
@NoArgsConstructor
@Getter
@Setter
public class BeerDto {

    @Null
    private UUID id;
    @Null
    private Integer version;
    @Null
    private OffsetDateTime createdDate;
    @Null
    private OffsetDateTime modifiedDate;

    @NotBlank
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;
    @NotNull
    @Positive
    private Long upc;
    @NotNull
    @Positive
    private BigDecimal price;
    private Integer quantityOfHand;

    @Builder
    public BeerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime modifiedDate, String beerName, BeerStyleEnum beerStyle, Long upc, BigDecimal price, Integer quantityOfHand) {
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.price = price;
        this.quantityOfHand = quantityOfHand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerDto beerDto = (BeerDto) o;
        return Objects.equals(id, beerDto.id) && Objects.equals(version, beerDto.version) && Objects.equals(createdDate, beerDto.createdDate) && Objects.equals(modifiedDate, beerDto.modifiedDate) && Objects.equals(beerName, beerDto.beerName) && beerStyle == beerDto.beerStyle && Objects.equals(upc, beerDto.upc) && Objects.equals(price, beerDto.price) && Objects.equals(quantityOfHand, beerDto.quantityOfHand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, createdDate, modifiedDate, beerName, beerStyle, upc, price, quantityOfHand);
    }

    @Override
    public String toString() {
        return "BeerDto{" +
                "id=" + id +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", beerName='" + beerName + '\'' +
                ", beerStyle=" + beerStyle +
                ", upc=" + upc +
                ", price=" + price +
                ", quantityOfHand=" + quantityOfHand +
                '}';
    }
}
