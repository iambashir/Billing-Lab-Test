package com.spring.feature.billing.lab.controller;

import com.spring.feature.billing.lab.dto.BillingModelDto;
import com.spring.feature.billing.lab.entity.BillingModel;
import com.spring.feature.billing.lab.service.BillingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
/*@RequestMapping("/v1/api")*/
public class BillingRestController {

    private final BillingService billingService;

    public BillingRestController(BillingService billingService) {
        this.billingService = billingService;
    }


    /**----- Save Employee One by One ------*/
    /*@PostMapping("/save-emp")
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            employeeService.saveEmployee(employeeDto);
            return ResponseEntity.ok("Employee saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while saving the employee: " + e.getMessage());
        }
    }*/

    /**
     * ----- Save All Employee ------
     */
    @PostMapping("/save/lab/data")
    public ResponseEntity<List<BillingModelDto>> saveAllBills(@RequestBody List<BillingModel> billDtos) {
        try {
            List<BillingModelDto> saveBills = billingService.saveAllBillData(billDtos);
            return new ResponseEntity<>(saveBills, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**----- Get All Employee ------*/
    /*@GetMapping("/get-all-emp")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        try {
            List<EmployeeDto> employees = employeeService.getAllEmployee();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


/*    *//**
     * ------- Get employee between dates ------
     *//*
    @GetMapping("/get/lab/data/{startDate}/{endDate}")
    public ResponseEntity<List<BillingModelDto>> getBillBetweenDates(
            *//**------ @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") -----**//*
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        try {
            List<BillingModelDto> bills = billingService.getBillBetweenDates(startDate, endDate);
            return new ResponseEntity<>(bills, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


    /**-------- Edit employee -----------*/
    /*@GetMapping("edit-emp/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        try {
            EmployeeDto employeeDto = employeeService.getEmployeeByID(id);
            return new ResponseEntity<>(employeeDto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /**-------- Update employee -----------*/
    /*@PutMapping("update-emp/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        try {
            employeeDto.setId(id); // Ensure the correct ID is set in the DTO
            employeeService.updateEmployee(employeeDto);
            return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while updating the employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /**--------- Delete employee ---------*/
   /* @DeleteMapping("delete-emp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        try {
            employeeService.deleteEmployee(id );
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting the employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /**--------- Delete all employee ----------*/
   /* @DeleteMapping("delete-all-emp")
    public ResponseEntity<String> deleteAllEmployees() {
        try {
            employeeService.deleteAllEmployee();
            return ResponseEntity.ok("All employees have been deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while deleting employees: " + e.getMessage());
        }
    }*/


}
