package com.spring.feature.billing.lab.entity;

import com.spring.feature.billing.lab.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(updatable = false)
    private LocalDate createDate;
    private int age;
    private boolean isRefund;
    private String patientName;
    private boolean isFreePatient;
    private String invoiceNumber;
    private String patientIdentifier;
    private String sex;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> lines = new ArrayList<>();

    @PrePersist
    public void setPreInsertData() {
        this.createDate = LocalDate.now();
    }



}
