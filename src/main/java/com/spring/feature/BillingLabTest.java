package com.spring.feature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BillingLabTest {

  public static void main(String[] args) {
    SpringApplication.run(BillingLabTest.class, args);
      System.out.println("Project is running .....................");


  }
/*  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }*/

}
