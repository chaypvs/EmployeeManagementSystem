package com.as.emsbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class employee {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
private Long id;
  @Column(name="first-Name")
private String firstName;
  @Column(name="last_Name")
private String lastName;
  @Column(name="email_id",nullable = false,unique = true)
private String email;

}
