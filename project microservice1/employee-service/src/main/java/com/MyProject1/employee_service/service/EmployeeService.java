package com.MyProject1.employee_service.service;

import com.MyProject1.employee_service.dto.ApiResponseDto;
import com.MyProject1.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long id);
}
