package com.example.ExceptionHandling.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="__user__")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private String email;

    private String mobileNumber;
    private String gender;
}
