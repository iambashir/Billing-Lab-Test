package com.spring.feature.billing.lab.controller;

import com.spring.feature.billing.lab.dto.BillingModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class Billing {
    private final RestTemplate restTemplate;

    @Autowired
    public Billing(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/lab-form")
    public String showLabBillingForm(Model model) {
        model.addAttribute("billingModelDto", new BillingModelDto());
        return "index2";
    }

    @PostMapping("/lab-form")
    public String saveLabBillingData(BillingModelDto billingModelDto) {
        // Send the data to the REST controller using RestTemplate
        restTemplate.postForObject("http://localhost:8069/save/lab/data", billingModelDto, BillingModelDto.class);
        return "redirect:/lab-form"; // Redirect to the form after saving
    }
}
