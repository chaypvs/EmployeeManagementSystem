package com.as.emsbe.mapper;


import com.as.emsbe.dto.employeeDto;
import com.as.emsbe.entity.employee;

public class employeeMapper {
public static employeeDto maptoEmployeeDto(employee Employee){

  return new employeeDto(Employee.getId(), Employee.getFirstName(), Employee.getLastName(),
      Employee.getEmail());
}

public static employee maptoEmployee(employeeDto EmployeeDto){
  return new employee(EmployeeDto.getId(),EmployeeDto.getFirstName(),
      EmployeeDto.getLastName(),EmployeeDto.getEmail());
}
}
