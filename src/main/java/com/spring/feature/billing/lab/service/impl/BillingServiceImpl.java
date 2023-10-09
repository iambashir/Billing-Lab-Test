package com.spring.feature.billing.lab.service.impl;

import com.spring.feature.billing.lab.dto.BillingModelDto;
import com.spring.feature.billing.lab.entity.BillingModel;
import com.spring.feature.billing.lab.entity.ProductModel;
import com.spring.feature.billing.lab.repository.BillingRepository;
import com.spring.feature.billing.lab.service.BillingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepository billingRepository;
    private final ModelMapper modelMapper;

    public BillingServiceImpl(BillingRepository billingRepository, ModelMapper modelMapper) {
        this.billingRepository = billingRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public BillingModelDto createBill() {
        BillingModel biiling = modelMapper.map(new BillingModelDto(), BillingModel.class);
        return modelMapper.map(biiling, BillingModelDto.class);
    }

    @Override
    public Object saveBill(BillingModelDto billingModelDto) {
        BillingModel bills = modelMapper.map(billingModelDto, BillingModel.class);
        billingRepository.save(bills);
        return null;
    }

    @Override
    public List<BillingModelDto> saveAllBillData(List<BillingModel> billingModels) {
        List<BillingModel> saveBill = billingRepository.saveAll(billingModels);
        return saveBill.stream().map(bill -> modelMapper.map(bill, BillingModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BillingModelDto> getAllBill() {
        List<BillingModel> bills = billingRepository.findAll();
        return bills.stream().map(bill -> modelMapper.map(bill, BillingModelDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BillingModelDto> getBillBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<BillingModel> billBetween = billingRepository.findByCreateDateBetween(startDate, endDate);
        return billBetween.stream().map(bills -> modelMapper.map(bills, BillingModelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addBill(BillingModel billingModel) {
        billingModel.getLines().add(new ProductModel());
    }

    @Override
    public void removeBill(BillingModel billingModel, Integer billIndex) {
        billingModel.getLines().remove(billIndex.intValue());
    }

    /*private final EmployeeRepository employeeRepository;*/
    /*private final ModelMapper modelMapper;*/

    /*public BillingServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }*/

    /**------- Save employee one by one ------*/
    /*@Override
    public void saveEmployee(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = modelMapper.map(employeeDto, EmployeeModel.class);
        employeeRepository.save(employeeModel);
    }*/

    /**------- Save All employee ------*/
    /*@Override
    public List<EmployeeDto> saveAllEmployee(List<EmployeeModel> employeeModels) {
        List<EmployeeModel> saveEmp = employeeRepository.saveAll(employeeModels);
        return saveEmp.stream().map(empl -> modelMapper.map(empl, EmployeeDto.class)).collect(Collectors.toList());
    }*/

    /**------- Get All employee ------*/
    /*@Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeModel> empmodel = employeeRepository.findAll();
        return empmodel.stream().map(emp -> modelMapper.map(emp, EmployeeDto.class))
                .collect(Collectors.toList());

    }*/


    /**------- Get employee between dates ------*/
    /*@Override
    public List<EmployeeDto> getEmployeeBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<EmployeeModel> empBetween = employeeRepository.findByLocalDateBetween(startDate, endDate);
        return empBetween.stream().map(emps -> modelMapper.map(emps, EmployeeDto.class))
                .collect(Collectors.toList());
    }*/


    /**------- Edit employee (Get by id) ------*/
    /*@Override
    public EmployeeDto getEmployeeByID(Long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        return modelMapper.map(employeeModel, EmployeeDto.class);
    }*/

    /**------- Update employee ------*/
    /*@Override
    public Void updateEmployee(EmployeeDto employeeDto) {
        EmployeeModel employeeModel = employeeRepository.findById(employeeDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        modelMapper.map(employeeDto, employeeModel);
        employeeRepository.save(employeeModel);
        return null;
    }*/

    /**------- Delete employee ------*/
    /*@Override
    public void deleteEmployee(Long id) {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));
        employeeRepository.delete(employeeModel);
    }*/

    /**------- Delete All employee ------*/
    /*@Override
    public void deleteAllEmployee() {
        List<EmployeeModel> allEmployees = employeeRepository.findAll();
        employeeRepository.deleteAll(allEmployees);
    }*/

}
