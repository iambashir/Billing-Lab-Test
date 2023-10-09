package com.spring.feature.billing.lab.service;

import com.spring.feature.billing.lab.dto.BillingModelDto;
import com.spring.feature.billing.lab.entity.BillingModel;

import java.time.LocalDate;
import java.util.List;

public interface BillingService {


    BillingModelDto createBill();

    /**------- Save employee one by one ------*/
   Object saveBill(BillingModelDto BillingModelDto);

    /**------- Save All Bill ------*/
    List<BillingModelDto> saveAllBillData(List<BillingModel> billingModels);

    /**------- Get All Bill ------*/
    List<BillingModelDto> getAllBill();

    /**------- Get Bill between dates ------*/
    List<BillingModelDto> getBillBetweenDates(LocalDate startDate, LocalDate endDate);

    /**------- Edit employee ------*/
   /* EmployeeDto getEmployeeByID(Long id);*/

    /**------- Update employee ------*/
    /*Void updateEmployee(EmployeeDto employeeDto);*/

    /**------- Delete employee ------*/
   /* void deleteEmployee(Long id);*/

    /**------- Delete All employee ------*/
    /*void deleteAllEmployee();*/


    void addBill(BillingModel billingModel);

    void removeBill(BillingModel billingModel, Integer billIndex);


}
