package com.springhystrixschoolservice.springhystrixschoolservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springhystrixschoolservice.springhystrixschoolservice.beans.Employee;
import com.springhystrixschoolservice.springhystrixschoolservice.service.StudentServiceDelegate;

@RestController
public class SchoolServiceController {

	@Autowired
	StudentServiceDelegate studentServiceDelegate;

	@RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String schoolname) {
		System.out.println("Going to call student service to get data!");
		return studentServiceDelegate.callStudentServiceAndGetData(schoolname);
	}

	@RequestMapping(value = "/getEmployeeDetails/{companyName}", method = RequestMethod.GET)
	public List<Employee> getEmployeeDetails(@PathVariable String companyName) {
		return null;

	}
}
