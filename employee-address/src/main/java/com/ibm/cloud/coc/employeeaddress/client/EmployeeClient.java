/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.client;

import com.ibm.cloud.coc.employeeaddress.domain.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author PravinDeshmukh
 */
@FeignClient(name = "employee",url = "${microservices.employee.url}", fallback = HystrixClientFallback.class)
public interface EmployeeClient {
    @GetMapping("/api/employee/{id}")
    public Employee findByEmpId(@PathVariable("id") String id);    
}


class HystrixClientFallback implements EmployeeClient{
        @Override
        public Employee findByEmpId(String id){
        return new Employee("001","Dummy", "IBM Employee", null,"GBS-CoC");                
    } 
}