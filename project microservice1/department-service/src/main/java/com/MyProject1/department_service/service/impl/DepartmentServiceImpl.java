package com.MyProject1.department_service.service.impl;

import com.MyProject1.department_service.dto.DepartmentDto;
import com.MyProject1.department_service.entity.Department;
import com.MyProject1.department_service.repository.DepartmentRepository;
import com.MyProject1.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // Ensure you use the correct getters here:
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getName(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()



        );

        // Save the department entity to the database
        Department savedDepartment = departmentRepository.save(department);

        // Create a DTO from the saved Department entity
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getName(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );

        // Return the saved Department DTO
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department =departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;

    }
}
