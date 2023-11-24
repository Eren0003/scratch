package com.example.ExceptionHandling.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull
    private String name;
    @Min(18)
    @Max(60)
    private int age;
    @NotNull
    private String email;
    @Size(min = 10,max = 10)
    @NotNull
    private String mobileNumber;
    private String gender;
}
