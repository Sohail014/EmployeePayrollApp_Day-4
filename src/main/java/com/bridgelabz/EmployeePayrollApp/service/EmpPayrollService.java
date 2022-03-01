package com.bridgelabz.EmployeePayrollApp.service;

import com.bridgelabz.EmployeePayrollApp.model.Employee;
import com.bridgelabz.EmployeePayrollApp.repository.EmployeePayrollRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpPayrollService {

    @Autowired
    EmployeePayrollRepository employeePayrollRepository;

    public Employee createEmpData(Employee model) {
        return employeePayrollRepository.save(model);
    }

    public List<Employee> getEmpData() {
        return employeePayrollRepository.findAll();
    }

    public Optional<Employee> getByID(int id) {
        return employeePayrollRepository.findById(id);

    }

    public void deleteById(int id) {
        employeePayrollRepository.deleteById(id);
    }

    public Employee updateDataById(Integer id, @NotNull  Employee model) {
        Employee newEmployee = new Employee(id, model.getFirstName(), model .getLastName(), model .getProfilePic(),model.getGender(), model .getDepartment(), model .getSalary(), model .getDate(), model .getNotes());
        return employeePayrollRepository.save(newEmployee);


    }
}
