/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.controller;

import com.ibm.cloud.coc.employeeaddress.client.EmployeeClient;
import com.ibm.cloud.coc.employeeaddress.domain.EmployeeAddress;
import com.ibm.cloud.coc.employeeaddress.repository.EmployeeAddressRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PravinDeshmukh
 */
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/employeeaddress")
@RestController
public class EmployeeAddressController {
    
    @Autowired
    private EmployeeAddressRepository addressRepository;
    
    @Autowired
    private EmployeeClient employeeClient;
    
    @GetMapping("/")
    public List<EmployeeAddress> findAll(){
        return this.addressRepository.findAll();
    }
    
    @GetMapping("/id")
    public List<EmployeeAddress> findByEmpId(@PathVariable String id){
     return this.addressRepository.findByEmpId(id);   
    }
    
    @PostMapping("/")
    public EmployeeAddress createAddress(@RequestBody EmployeeAddress employeeAddress){
     return this.addressRepository.save(employeeAddress);  
    }
    
    @GetMapping("/country")
    public List<EmployeeAddress> findEmployeeByCountry(@PathVariable String country){
        log.info("Find Employees by : country={}", country);
        List<EmployeeAddress> addresses = addressRepository.findByCountry(country);
        addresses.forEach(a -> a.setEmployee(employeeClient.findByEmpId(a.getEmpId())));        
        return addresses;
    }
}
