package com.example.employeetest.models;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    private Long id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
    private Float annualSalary;

}
