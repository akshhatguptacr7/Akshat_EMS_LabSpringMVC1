package com.gl.ems.EmployeeManagementSystem.controller;

import com.gl.ems.EmployeeManagementSystem.entity.Employee;
import com.gl.ems.EmployeeManagementSystem.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<Employee> empList = employeeService.getAllEmployees();
        model.addAttribute("employees",empList);
        return "employees";
    }

    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model)
    {
        Employee e1=new Employee();
        model.addAttribute("employee",e1);
        return "create_employee";
    }@GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable int id, Model model)
    {
        Employee empdb=employeeService.getEmployeeById(id);
        model.addAttribute("employee",empdb);
        return "edit_employee";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee e1)
    {
        employeeService.saveEmployee(e1);
        return "redirect:/employees";
    }


    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable int id,@ModelAttribute("employee") Employee newvalues)
    {
        Employee empdb=employeeService.getEmployeeById(id);
        empdb.setFirstName(newvalues.getFirstName());
        empdb.setLastName(newvalues.getLastName());
        empdb.setEmail(newvalues.getEmail());
        employeeService.updateEmployee(empdb);
        return "redirect:/employees";
    }

}
