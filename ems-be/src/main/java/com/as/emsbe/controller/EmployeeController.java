package com.as.emsbe.controller;
import com.as.emsbe.dto.employeeDto;
import com.as.emsbe.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
private EmployeeService employeeService;
//build add employee rest api
  @PostMapping
public ResponseEntity<employeeDto> createEmployee(@RequestBody employeeDto EmployeeDto){
  employeeDto savedemployee =employeeService.createemployee(EmployeeDto);
  return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);
}
// build get employeeid method api
@GetMapping("{id}")
public ResponseEntity<employeeDto> getemployeeById(@PathVariable("id") Long employeeId){
    employeeDto EmployeeDto =employeeService.getemployeeById(employeeId);
    return ResponseEntity.ok(EmployeeDto);
}
// getall RestAPI
  @GetMapping
  public ResponseEntity<List<employeeDto>> getallemployees(){
    List<employeeDto> employees =employeeService.getAllemployees();
    return ResponseEntity.ok(employees);
  }
  //UPDATE RESTAPI
 @PutMapping("{id}")
 public ResponseEntity<employeeDto> updatedEmployee(@PathVariable("id")   Long employeeId,@RequestBody     employeeDto updatedEmployee){
    employeeDto EmployeeDto=employeeService.updateEmployee(employeeId,updatedEmployee);
    return ResponseEntity.ok(EmployeeDto);
  }
  // delete restapi
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteEmployee(@PathVariable("id")   Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("Employee deleted Succesfully");
  }
}
