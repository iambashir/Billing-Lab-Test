package com.spring.feature.billing.lab.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.feature.billing.lab.entity.Contact;
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

    @JsonProperty("patientId")
    private String patientId;
    @JsonProperty("contactNumber")
    private String contactNumber;
    @JsonProperty("brnNumber")
    private String brnNumber;
    @JsonProperty("nationalId")
    private String nationalId;
    @JsonProperty("email")
    private String email;
    @JsonProperty("patientCategory")
    private String patientCategory;

}
