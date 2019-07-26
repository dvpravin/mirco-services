/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeemicroservice.controller;

import com.ibm.cloud.coc.employeemicroservice.domain.Employee;
import com.ibm.cloud.coc.employeemicroservice.dto.EmployeeDto;
import com.ibm.cloud.coc.employeemicroservice.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@AllArgsConstructor
@RequestMapping("/api/employee")
@RestController
public class EmployeeController {
    
    private EmployeeService employeeService;
    
    @GetMapping("/byfname/{firstName}")
    public List<EmployeeDto> findByFirstName(@PathVariable String firstName){
        return this.employeeService.findByFirstName(firstName);
    }
    
    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id){
        return this.employeeService.findById(id);
    }
    
    @GetMapping
    public List<EmployeeDto> findAll() {
        return this.employeeService.findAll();
    }
    
    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto responseEmployeeDto = this.employeeService.create(employeeDto);
        return new ResponseEntity<EmployeeDto>(responseEmployeeDto,HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public void delete(String id) {
        this.employeeService.delete(id);
    }
}
