package com.spring.feature.billing.lab.entity;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billing")
public class BillingModel {

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
  private List<ProductModel> lines = new ArrayList<>();

  @PrePersist
  public void setPreInsertData() {
    this.createDate = LocalDate.now();
  }

}
