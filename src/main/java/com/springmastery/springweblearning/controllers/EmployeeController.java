package com.springmastery.springweblearning.controllers;

import com.springmastery.springweblearning.dto.EmployeeDTO;
import com.springmastery.springweblearning.entities.EmployeeEntity;
import com.springmastery.springweblearning.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(
            @PathVariable(name = "employeeId") Long id
    ) {
        Optional<EmployeeDTO> foundEmployee = employeeService.findById(id);
        return foundEmployee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(
            @RequestParam(required = false) String sortKey,
            @RequestParam(required = false, name = "sortOrder") String sortBy
    ) {
        System.out.println("The passed sort Key is: " + sortKey + " and sort order is: " + sortBy);
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping(path = "/employee")
    public ResponseEntity<EmployeeDTO> saveEmployee(
            @RequestBody EmployeeDTO inputEmployee
    ) {
        EmployeeDTO savedEmployee = employeeService.save(inputEmployee);
        return new ResponseEntity(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/employee/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable(name = "employeeId") Long empId,
            @RequestBody EmployeeDTO inputEmployee
    ) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployeeById(empId, inputEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(
            @PathVariable(name = "employeeId") Long empId
    ) {
        Boolean isDeleted = employeeService.deleteEmployeeById(empId);
        if(isDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> partialUpdateEmployee(
            @PathVariable(name = "employeeId") Long empId,
            @RequestBody Map<String, Object> updates
    ) {
        EmployeeDTO patchedEmployee = employeeService.partialUpdateEmployeeById(empId, updates);
        if (patchedEmployee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(patchedEmployee);
    }
}
