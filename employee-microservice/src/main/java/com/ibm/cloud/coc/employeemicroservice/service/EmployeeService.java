/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeemicroservice.service;

import com.ibm.cloud.coc.employeemicroservice.domain.Employee;
import com.ibm.cloud.coc.employeemicroservice.dto.EmployeeDto;
import com.ibm.cloud.coc.employeemicroservice.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PravinDeshmukh
 */

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeService {
 
    //@Autowired
    private final EmployeeRepository employeeRepository;
 
    public List<EmployeeDto> findByFirstName(String firstName){
        return this.employeeRepository.findByFirstName(firstName)
                .stream()
                .map(EmployeeService::mapToDto)
                .collect(Collectors.toList());
    }
    
    public List<EmployeeDto> findAll() {
        return this.employeeRepository.findAll()
                .stream()
                .map(EmployeeService::mapToDto)
                .collect(Collectors.toList());
    }
    
    public EmployeeDto create(EmployeeDto employeeDto) {
        log.debug("Request to create Employee : {}", employeeDto);
        return mapToDto(this.employeeRepository.save(
                new Employee(
                        employeeDto.getId(),
                        employeeDto.getFirstName(),
                        employeeDto.getLastName(),
                        employeeDto.getBirthDate(),
                        employeeDto.getDepartmentId())
                ));
    }

    public void delete(Long id) {
        log.debug("Request to delete Employee : {}", id);
        this.employeeRepository.deleteById(id);
    }
    
    public static EmployeeDto mapToDto(Employee employee){
        if(employee!=null){
            return new EmployeeDto(employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getBirthDate(),
                    employee.getDepartmentId());
        }else
            return null;
    }
}
