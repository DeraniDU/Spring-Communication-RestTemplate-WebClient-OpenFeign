package com.MyProject1.employee_service.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class DepartmentDto {

    private Long id;
    private String name;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
