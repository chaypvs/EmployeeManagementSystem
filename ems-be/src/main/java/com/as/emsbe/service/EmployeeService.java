package com.as.emsbe.service;
import com.as.emsbe.dto.employeeDto;
import java.util.List;

public interface EmployeeService {
  employeeDto createemployee(employeeDto EmployeeDto);
  employeeDto getemployeeById(Long employeeId);
  List<employeeDto> getAllemployees();

  employeeDto updateEmployee(Long employeeId,employeeDto updatedEmployee);

   void deleteEmployee(Long employeeId);

}
