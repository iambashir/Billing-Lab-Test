package com.spring.feature.billing.lab.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="billing_product")
public class ProductModel{


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id", insertable = false, updatable = false, nullable = false)
  private UUID uuid;
  private String productName;

 /* @ManyToOne (fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "products")
  private BillingModel billingProducts;*/


}
