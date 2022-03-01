package com.bridgelabz.EmployeePayrollApp.controller;


import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.EmpPayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/emp")

public class EmployeePayrollController {

    @Autowired
    EmpPayrollService empPayrollService;


    //ability to save employee details to repository
    @PostMapping("/create")
    public Employee createEmployeeData(@RequestBody Employee model){
        Employee newEmpdata = empPayrollService.createEmpData(model);
        return newEmpdata;
    }


    //ability to get all employees data
    @GetMapping("/getAll")
    public List<Employee> getAllData(){
        List<Employee> getData=empPayrollService.getEmpData();
        return getData;
    }


    //ability to get employee data by id
    @GetMapping("/getbyId/{id}")
    public Optional<Employee> getDataByID(@PathVariable int id){
        Optional<Employee> empdata = empPayrollService.getByID(id);
        return empdata;
    }


    //ability to delete employee data for particular id
    @DeleteMapping ("/deletebyId/{id}")
    public String deleteDataById(@PathVariable int id){
      empPayrollService.deleteById(id);
        return "employee deleted succesfully";
    }


    //ability to update employee data for particular id
    @PutMapping("/update/{id}")
    public Employee updateDataInRepo(@PathVariable Integer id, @RequestBody Employee model) {
         Employee updateDataById =empPayrollService.updateDataById(id, model);
         return updateDataById;
    }




}
