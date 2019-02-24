package com.springhystrixschoolservice.springhystrixschoolservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springhystrixschoolservice.springhystrixschoolservice.beans.Employee;
import com.springhystrixschoolservice.springhystrixschoolservice.proxy.EmployeeServiceProxy;

@Service
public class EmployeeServiceDelegate {

	@Autowired
	private EmployeeServiceProxy proxy;

	@HystrixCommand(fallbackMethod = "callEmployeeServiceAndGetData_Fallback")

	public String callStudentServiceAndGetData(String companyName) {

		System.out.println("Getting Employee details for " + companyName);

		List<Employee> response = proxy.getEmployeeDetails(companyName);

		System.out.println("Response Received as " + response + " -  " + new Date());

		return "NORMAL FLOW !!! - Company Name -  " + companyName + " :::  " + " Employee Details " + response + " -  "
				+ new Date();
	}

	@SuppressWarnings("unused")
	private String callEmployeeServiceAndGetData_Fallback(String companyName) {

		System.out.println("Employee Service is down!!! fallback route enabled...");

		return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. "
				+ " Service will be back shortly - " + new Date();
	}
}
