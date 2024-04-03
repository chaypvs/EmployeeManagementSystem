package com.as.emsbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.as.emsbe.entity.employee;
public interface employeeRepository extends JpaRepository<employee,Long> {

}
