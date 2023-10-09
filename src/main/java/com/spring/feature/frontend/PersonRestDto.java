package com.spring.feature.frontend;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonRestDto{

    @JsonProperty("create_date")
    private LocalDate createDate;
    private List<Contact> lines = new ArrayList<>();
    private int age;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("is_refund")
    private boolean isRefund;
    @JsonProperty("is_free_patient")
    private boolean isFreePatient;
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("patient_identifier")
    private String patientIdentifier;
    private String sex;

}
