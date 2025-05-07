package com.example.javaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.javaproject.Convertors.*;

@SpringBootApplication
public class JavaprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaprojectApplication.class, args);
	}

	@Bean
	public BusConvertor getBusConvertor(){
		return new BusConvertor();
	}

	@Bean
	public DriverConvertor getDriverConvertor(){
		return new DriverConvertor();
	}

	@Bean
	public LineConvertor getLineConvertor(){
		return new LineConvertor();
	}

	@Bean
	public StationConvertor getStationConvertor(){
		return new StationConvertor();
	}

	@Bean
	public TravelConvertor getTravelConvertor(){
		return new TravelConvertor();
	}

}
