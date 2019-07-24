/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeeaddress.repository;

import com.ibm.cloud.coc.employeeaddress.domain.EmployeeAddress;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PravinDeshmukh
 */

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {
    public List<EmployeeAddress> findByEmpId(String empId);
}
