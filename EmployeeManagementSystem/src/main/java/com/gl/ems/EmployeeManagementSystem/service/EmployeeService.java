package com.gl.ems.EmployeeManagementSystem.service;

import com.gl.ems.EmployeeManagementSystem.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(int id);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
