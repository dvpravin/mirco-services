/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibm.cloud.coc.employeemicroservice.repository;

import com.ibm.cloud.coc.employeemicroservice.domain.Employee;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PravinDeshmukh
 */
@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    public List<Employee> findByFirstName(String firstName);
}
