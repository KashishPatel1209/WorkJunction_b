package com.workjunctionn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.workjunctionn.JobPortalApplication;


@SpringBootApplication

public class JobPortalApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(JobPortalApplication.class, args);
	}
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 * .build(); }
	 */
    
}
