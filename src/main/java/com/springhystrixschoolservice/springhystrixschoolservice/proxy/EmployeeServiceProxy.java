package com.springhystrixschoolservice.springhystrixschoolservice.proxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springhystrixschoolservice.springhystrixschoolservice.beans.Employee;

@FeignClient(name = "spring-hystrix-student-employee-service", url = "localhost:8098")
@RibbonClient(name = "spring-hystrix-student-employee-service")
public interface EmployeeServiceProxy {

	@RequestMapping(value = "/getEmployeeDetails/{companyName}", method = RequestMethod.GET)
	public List<Employee> getEmployeeDetails(@PathVariable("companyName") String companyName);
}
