package com.bridgelabz.EmployeePayrollApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseDTO {

    private String message;
    private Object data;

//    public ResponseDTO(String message, Object data) {
//        this.message = message;
//        this.data = data;
//    }
}
