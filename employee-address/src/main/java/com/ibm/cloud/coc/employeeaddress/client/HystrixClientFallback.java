/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.client;

import com.ibm.cloud.coc.employeeaddress.domain.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author PravinDeshmukh
 */
@Component
public class HystrixClientFallback implements EmployeeClient{
        @Override
        public Employee findByEmpId(String id){
        return new Employee("001","Dummy", "IBM Employee", null,"GBS-CoC");                
    } 
}