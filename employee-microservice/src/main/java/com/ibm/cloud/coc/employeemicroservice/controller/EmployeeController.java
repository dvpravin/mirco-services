/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeemicroservice.controller;

import com.ibm.cloud.coc.employeemicroservice.dto.EmployeeDto;
import com.ibm.cloud.coc.employeemicroservice.service.EmployeeService;
import java.util.List;
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
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private EmployeeService employeeService;
    
    @GetMapping("/{firstName}")
    public List<EmployeeDto> findByFirstName(@PathVariable String name){
        return this.employeeService.findByFirstName(name);
    }
    
    @GetMapping
    public List<EmployeeDto> findAll(String name) {
        return this.employeeService.findAll(name);
    }
    
    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto responseEmployeeDto = this.employeeService.create(employeeDto);
        return new ResponseEntity<EmployeeDto>(responseEmployeeDto,HttpStatus.OK);
    }
    
    @DeleteMapping
    public void delete(Long id) {
        this.employeeService.delete(id);
    }
}
