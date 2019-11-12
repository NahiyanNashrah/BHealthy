package com.doctormanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.doctormanagement.model.StorageProperties;




@EnableConfigurationProperties(StorageProperties.class)
@SpringBootApplication
public class BeHealthyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeHealthyApplication.class, args);
	}

}
