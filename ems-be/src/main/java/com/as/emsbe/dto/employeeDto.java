package com.as.emsbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeDto {
private Long id;
private String firstName;
private String lastName;
private String email;
}
