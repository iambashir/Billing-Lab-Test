package com.spring.feature.billing.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactRestDto {

    private UUID uuid;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("category_name")
    private String categoryName;
    @JsonProperty("price_unit")
    private String priceUnit;

}
