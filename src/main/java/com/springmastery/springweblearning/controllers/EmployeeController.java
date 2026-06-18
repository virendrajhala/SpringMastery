package com.springmastery.springweblearning.controllers;

import com.springmastery.springweblearning.dto.EmployeeDTO;
import com.springmastery.springweblearning.entities.EmployeeEntity;
import com.springmastery.springweblearning.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployee(
            @PathVariable(name = "employeeId") Long id
    ){
        Optional<EmployeeEntity> foundEmployee = employeeRepository.findById(id);
        return foundEmployee.orElse(null);
    }

    @GetMapping("")
    public List<EmployeeEntity> getEmployees(
            @RequestParam(required = false) String sortKey,
            @RequestParam(required = false,name = "sortOrder") String sortBy
    ){
        System.out.println("The passed sort Key is: " + sortKey + " and sort order is: " + sortBy);
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/employee")
    public EmployeeEntity saveEmployee(
            @RequestBody EmployeeEntity inputEmployee
    ){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping(path = "/employee")
    public EmployeeEntity updateEmployee(
            @RequestBody EmployeeEntity inputEmployee
    ){
        return employeeRepository.save(inputEmployee);
    }
}
