package com.bridgelabz.EmployeePayrollApp.model;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
    private String profilePic;
    private Integer salary;
    private String gender;
    private String department;
    private LocalDate date;
    private String notes;

    public Employee(Integer id, String firstName, String lastName, String profilePic,String gender, String department, Integer salary, LocalDate date, String notes) {



    super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.notes = notes;
        this.gender=gender;
   }
}

