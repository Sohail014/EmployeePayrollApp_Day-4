package com.bridgelabz.EmployeePayrollApp.service;


import com.bridgelabz.EmployeePayrollApp.dto.EmployeePayrollDTO;
import com.bridgelabz.EmployeePayrollApp.exception.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpPayrollService implements IEmpPayrollServices {

    @Autowired
    private EmployeePayrollRepository employeeRepository;


    /**
     * accepts the employee data in the form of EmployeePayrollDTO and stores it in DB
     * @param empPayrollDTO - represents object of EmployeePayrollDTO class
     * @return accepted employee information in JSON format
     */

    @Override
    public Employee createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        Employee employee = new Employee(empPayrollDTO);
        return employeeRepository.save(employee);
    }



    /**
     * @return list of employee information from DB
     */
    @Override
    public List<Employee> getEmployeePayrollData() {
        return (List<Employee>) employeeRepository.findAll();
    }

    /**
     * @param empId - represents employee id
     * @return employee information with same empId
     */
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> new EmployeePayrollException("Employee with employee Id"+empId
                +"  does not exist!!"));
    }



    /**
     * accepts the employee data in the form of EmployeePayrollDTO and
     * updates the employee having same empId from database
     * @param empId - represents employee id
     * @param empPayrollDTO - represents object of EmployeePayrollDTO class
     * @return	updated employee information in JSON format
     */
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeeRepository.save(empData);
    }

    /**accepts the empId and deletes the data of that employee from DB
     * @param empId - represents employee id
     * @return empId and Acknowledgment message
     */

    @Override
    public void deleteEmployeePayrollData(int empId) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empData);
    }

}
