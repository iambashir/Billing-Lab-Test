package com.spring.feature.billing.lab.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BillingModelDto {

    @JsonProperty("create_date")
    private LocalDate createDate;
    private List<ProductModelDto> lines;
    private int age;
    @JsonProperty("is_refund")
    private boolean isRefund;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("is_free_patient")
    private boolean isFreePatient;
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("patient_identifier")
    private String patientIdentifier;
    private String sex;

}
