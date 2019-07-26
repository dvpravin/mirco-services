/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.client;

import com.ibm.cloud.coc.employeeaddress.domain.Employee;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author PravinDeshmukh
 */
@FeignClient(name = "employee",url = "${microservices.employee.url}")
public interface EmployeeClient {
    
    @GetMapping("/api/employee/{empId}")
    List<Employee> findByEmpId(@PathVariable("empId") String empId);
}
