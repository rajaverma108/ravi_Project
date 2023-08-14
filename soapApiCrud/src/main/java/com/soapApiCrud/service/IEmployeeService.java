package com.soapApiCrud.service;

import com.soapApiCrud.entities.Employee;

public interface IEmployeeService {

	 void AddEmployee(Employee employee);
	 
	 Employee getEmployeeById(long employeeId);
	 
     void updateEmployee(Employee employee);
     
     void deleteEmployee(long employeeId);
}
