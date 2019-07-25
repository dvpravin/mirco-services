package com.ibm.cloud.coc.employeeaddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories
public class EmployeeAddressApplication {
    
    	@Value("${VERSION}")
	String version;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAddressApplication.class, args);
	}
        
        @Bean
        public Docket swaggerApi(){
            		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.ibm.cloud.coc.employeeaddress.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version(version).title("Employee Address API").description("Documentation for Employee Address API v" + version).build());
        }

        @Bean
        UiConfiguration uiConfig() {
            return new UiConfiguration(Boolean.TRUE, Boolean.FALSE, 1, 1, ModelRendering.MODEL, Boolean.FALSE, DocExpansion.LIST, Boolean.FALSE, null, OperationsSorter.ALPHA, Boolean.FALSE, TagsSorter.ALPHA, UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, null);
        }

}
