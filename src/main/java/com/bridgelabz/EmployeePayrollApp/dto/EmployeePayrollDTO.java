package com.bridgelabz.EmployeePayrollApp.dto;

import lombok.Data;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class EmployeePayrollDTO {


    /**
     @pattern will match the pattern and if the pattern is not match then it will shows a message "employee name invalid".
     */

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee firstName is Invalid")
    public String firstName;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee lastName is Invalid")
    public String lastName;



    /**
     * @min annotation :- we use min annotation here to make sure that every employee have salary atleast 8000, if in create record we gave
     * salary less than 8k then it will print a message that "min Wage should be more than 8000".
     */

    @Min(value = 5000, message = "min Wage should be more than 5000")
    public long salary;



    /**
     * here we initialize that the gender of the employee must be male or female only.
     */
    @Pattern(regexp = "male|female", message = "gender needs to be male or female")
    public String gender;



    /**
     * @notempty :- department can not be null
     */
    @NotEmpty(message = "Department name cannot be null")
    public String department;
    public String profilePic;
    public LocalDate date;
    public String notes;


}