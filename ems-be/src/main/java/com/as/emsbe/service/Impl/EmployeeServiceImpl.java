package com.as.emsbe.service.Impl;
import com.as.emsbe.exception.ResourceNotFoundException;
import com.as.emsbe.mapper.employeeMapper;
import com.as.emsbe.dto.employeeDto;
import com.as.emsbe.entity.employee;
import com.as.emsbe.service.EmployeeService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.as.emsbe.repository.employeeRepository;

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService{
private  employeeRepository EmployeeRepositary;

  @Override
  public employeeDto createemployee(employeeDto EmployeeDto) {
    employee Employee= employeeMapper.maptoEmployee(EmployeeDto);
    employee savedemployee  =  EmployeeRepositary.save(Employee);
    return employeeMapper.maptoEmployeeDto(savedemployee);
  }

  @Override
  public employeeDto getemployeeById(Long employeeId) {
   employee Employee =EmployeeRepositary.findById(employeeId)
       .orElseThrow(() ->new ResourceNotFoundException("Employee Doesn't exist with given ID:"+employeeId));

    return employeeMapper.maptoEmployeeDto(Employee);
  }

  @Override
  public List<employeeDto> getAllemployees() {
    List<employee> employees =EmployeeRepositary.findAll();
    return employees.stream().map((Employee)->employeeMapper.maptoEmployeeDto(Employee))
        .collect(Collectors.toList());



  }

  @Override
  public employeeDto updateEmployee(Long employeeId, employeeDto updatedEmployee) {
    employee Employee=EmployeeRepositary.findById(employeeId)
        .orElseThrow(()->new ResourceNotFoundException("Employee Doesn't exist with given ID:"+employeeId));
      Employee.setFirstName(updatedEmployee.getFirstName());
      Employee.setLastName(updatedEmployee.getLastName());
      Employee.setEmail(updatedEmployee.getEmail());
      employee updatedEmployeeobj =EmployeeRepositary.save(Employee);
    return employeeMapper.maptoEmployeeDto(updatedEmployeeobj);
  }

  @Override
  public void deleteEmployee(Long employeeId) {
    employee Employee=EmployeeRepositary.findById(employeeId)
        .orElseThrow(()->new ResourceNotFoundException("Employee Doesn't exist with given ID:"+employeeId));
    EmployeeRepositary.deleteById(employeeId);

  }


}
