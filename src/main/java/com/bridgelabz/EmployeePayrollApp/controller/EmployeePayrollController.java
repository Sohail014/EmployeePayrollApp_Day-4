package com.bridgelabz.EmployeePayrollApp.controller;


import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.service.IEmpPayrollServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("/emp")

public class EmployeePayrollController {

    @Autowired
    private IEmpPayrollServices empPayrollService;



    /**
     * create record
     * @apiNote accepts the employee data in JSON format and stores it in DB
     * @param empPayrollDTO - represents object of EmployeePayrollDTO class
     * @return accepted employee information in JSON format
     */

    @PostMapping(path = "/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
        Employee employee = empPayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Data ", employee);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    /**
     * Get all data
     * @return list of employee information from DB in JSON format
     */

    @GetMapping("/employees")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<Employee> empDataList = empPayrollService.getEmployeePayrollData();
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    /**
     * Get records by id
     * @param empId - represents employee id
     * @return employee information with same empId in JSON format
     */

    @GetMapping("/employee/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
       Employee employee = empPayrollService.getEmployeePayrollDataById(empId);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success", employee);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }




    /**
     * update  record data by id
     * @apiNote accepts the employee data in JSON format and updates the employee having same empId from database
     * @param empId - represents employee id
     * @param empPayrollDTO - represents object of EmployeePayrollDTO class
     * @return	updated employee information in JSON format
     */

    @PutMapping(path = "/update/{empId}", consumes = {"application/json"})
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO empPayrollDTO) {
        Employee employee = empPayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", employee);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }


    /**
     * delete records from database
     * @apiNote accepts the empId and deletes the data of that employee from DB
     * @param empId - represents employee id
     * @return empId and Acknowledgment message
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        empPayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO respDTO = new ResponseDTO("Deleted Employee Data ", empId);
        return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
    }
}