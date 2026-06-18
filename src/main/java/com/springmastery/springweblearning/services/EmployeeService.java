package com.springmastery.springweblearning.services;

import com.springmastery.springweblearning.dto.EmployeeDTO;
import com.springmastery.springweblearning.entities.EmployeeEntity;
import com.springmastery.springweblearning.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id).map(emp -> modelMapper.map(emp, EmployeeDTO.class));
    }

    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> foundEmployees = employeeRepository.findAll();
        return foundEmployees
                .stream()
                .map(
                emp -> modelMapper.map(emp, EmployeeDTO.class)
        ).collect(Collectors.toList());
    }

    public EmployeeDTO save(EmployeeDTO inputEmployee) {
        EmployeeEntity employeeToSave = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeToSave);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    /**
     * JPA save method does not upsert the record directly if the employee with id not present already in the system
     *
     * @param employeeId
     * @param inputEmployee
     * @return
     */
    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO inputEmployee) {
        EmployeeEntity employeeInDb = employeeRepository.findById(employeeId).orElseGet(EmployeeEntity::new);
        modelMapper.map(inputEmployee, employeeInDb);
        // employee does not exist in db, let generated value auto generate id for it
        // JPA tries to merge the content of the record found in db vs incoming if ids differ
        if (employeeInDb.getId() != null) {
            employeeInDb.setId(employeeId);
        }
        EmployeeEntity updatedEmployee = employeeRepository.save(employeeInDb);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    public Boolean isEmployeeExistsById(Long employeeId) {
        return employeeRepository.existsById(employeeId);
    }

    public Boolean deleteEmployeeById(Long employeeId) {
        if (!isEmployeeExistsById(employeeId)) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO partialUpdateEmployeeById(Long empId, Map<String, Object> updates) {
        EmployeeEntity employeeEntity = employeeRepository.findById(empId).orElse(null);
        if (employeeEntity == null) return null;

        updates.forEach((key, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeeEntity.class, key);
            if(fieldToBeUpdated != null) {
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
            }
        });

        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}
