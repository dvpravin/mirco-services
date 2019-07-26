/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author PravinDeshmukh
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "address")
public class EmployeeAddress {
    
    @Id
    @Column(name = "id")
    private Long id;
    
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "type")
    private String type;
    
    @Column(name = "street_address")
    private String streetAddress;
    
    @Column(name = "city")
    private String city;
    
    @Size(max=10)
    @Column(name = "zip_code", length = 10)
    private String zipCode;
    
    @Size(max=2)
    @Column(name = "state", length = 2)
    private String state;

    @Size(max=2)
    @Column(name = "country", length = 2)
    private String country;
    
    @Transient
    private List<Employee> employee = new ArrayList();
}
