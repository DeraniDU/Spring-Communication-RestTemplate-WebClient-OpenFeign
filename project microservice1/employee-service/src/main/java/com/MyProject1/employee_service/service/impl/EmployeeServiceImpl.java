package com.MyProject1.employee_service.service.impl;

import com.MyProject1.employee_service.dto.ApiResponseDto;
import com.MyProject1.employee_service.dto.DepartmentDto;
import com.MyProject1.employee_service.dto.EmployeeDto;
import com.MyProject1.employee_service.entity.Employee;
import com.MyProject1.employee_service.repository.EmployeeRepository;
import com.MyProject1.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
//@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RestTemplate restTemplate;



    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstname(),
                savedEmployee.getLastname(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()

        );
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity(
                "http://localhost:8081/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);



        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getDepartmentCode()

        );


        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
