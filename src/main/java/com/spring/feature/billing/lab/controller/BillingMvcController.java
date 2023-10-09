package com.spring.feature.billing.lab.controller;

import com.spring.feature.billing.lab.dto.BillingModelDto;
import com.spring.feature.billing.lab.entity.BillingModel;
import com.spring.feature.billing.lab.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/bill")
public class BillingMvcController {

    public final BillingService billingService;
    public final ModelMapper modelMapper;


    @GetMapping("")
    public String invoice(Model model){
        model.addAttribute("createBill", billingService.createBill());
        return "index";
    }

    @GetMapping("/list")
    public String allBill(Model model){
        model.addAttribute("allBills", billingService.getAllBill());
        return "/billing-lab/bill-list";
    }


    @PostMapping("/addBill")
    public String addBill(BillingModel billingModel){
        billingService.addBill(billingModel);
        System.out.println("Add bill hit ......");
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/removeBill")
    public String removeBill(BillingModel billingModel, @RequestParam("removeBill") Integer billIndex){
        billingService.removeBill(billingModel, billIndex);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/save")
    public String save(BillingModelDto billingModelDto, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage", "The submitted data has errors.");
        }else {
            model.addAttribute("createBill", billingService.saveBill(billingModelDto));
            model.addAttribute("successMessage", "Person saved successfully!");
        }

        return "redirect:/bill/list";
    }



}
