package com.ibm.cloud.coc.employeeaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableJpaRepositories
public class EmployeeAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAddressApplication.class, args);
	}

}
