package com.spring.feature.billing.lab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContactDto {

    private Long id;
    private UUID uuid;
    @JsonProperty("product_name")
    private String productName;

}
