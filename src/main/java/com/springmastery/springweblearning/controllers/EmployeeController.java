package com.springmastery.springweblearning.controllers;

import com.springmastery.springweblearning.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping(path = "/secretMsg")
//    public String getMySecretMessage(){
//        return "Secret Message : Reffrrf87v98vv9v";
//    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(
            @PathVariable(name = "employeeId") Long id
    ){
        return new EmployeeDTO(
                id,
                "Virendra",
                "viru@gmail.com",
                28,
                LocalDate.of(2026,03,13),
                true
        );
    }

    @GetMapping("")
    public String getEmployees(
            @RequestParam(required = false) String sortKey,
            @RequestParam(required = false,name = "sortOrder") String sortBy
    ){
        return "The passed sort Key is: " + sortKey + " and sort order is: " + sortBy;
    }

    @PostMapping(path = "/employee")
    public EmployeeDTO saveEmployee(
            @RequestBody EmployeeDTO employeeDTO
    ){
        employeeDTO.setId(454343L);
        return employeeDTO;
    }

    @PutMapping(path = "/employee")
    public EmployeeDTO updateEmployee(
            @RequestBody EmployeeDTO employeeDTO
    ){
        return employeeDTO;
    }
}
