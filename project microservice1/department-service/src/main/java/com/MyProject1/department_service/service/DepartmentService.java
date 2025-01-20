package com.MyProject1.department_service.service;

import com.MyProject1.department_service.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto  saveDepartment(DepartmentDto departmentDto);
    DepartmentDto  getDepartmentByCode(String code);


}
