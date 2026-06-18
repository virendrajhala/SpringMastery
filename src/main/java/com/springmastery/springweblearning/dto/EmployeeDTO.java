package com.springmastery.springweblearning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springmastery.springweblearning.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 10,message = "No of characters in name should be in the range 3 and 10")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be a valid email")
    private String email;

    @NotNull(message = "Age is required")
    @Max(value=80,message = "Max age can be 80")
    @Min(value=18,message = "Min age can be 18")
    private Integer age;

    @PastOrPresent(message = "Date of joining must be in the past or present")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Only active employee is required")
    @JsonProperty("isActive")
    private Boolean isActive;

//    @Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role; // ADMIN,USER

    @Positive(message = "Salary should be valid positive number")
    @Digits(integer = 6,fraction = 2) // indicates decimal and integer value size
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.60")
    private Double salary;
}

//@NotNull
//@NotEmpty
//@NotBlank
//@Size
//@Max()
//@Email

