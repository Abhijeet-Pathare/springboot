package com.app.enterprise;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

//This is an example of Question number 3 in readme
// you can play around with this code by commenting and uncommenting the lines and adding ypur own as well
@Component
public class Controller {
	//Field Based DI
	@Autowired
	private BusinessService businessService;
	public long returnValueFromBusinessService() {
		return businessService.calculateSum();
	}
}

@Component
class BusinessService {
	
//	@Autowired
	private DataService dataService;
	
	
	//Setter DI
	@Autowired
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}

	public long calculateSum() {
		List<Integer> data = dataService.getData();
		long sum = data.stream().reduce(Integer::sum).get();
		return sum;
	}
}

@Component
class DataService{
	public List<Integer> getData(){
		return Arrays.asList(10,20,30,40);
	}
}
