/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeemicroservice.dto;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author PravinDeshmukh
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeDto {
    private Long id;    
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String department;
    
    public EmployeeDto(Long id, String firstName,String lastName, Date birthDate,String department){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
        this.department=department;
    }
}
