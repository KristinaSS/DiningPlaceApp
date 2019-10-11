package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountRepository employeeRepository;

    @GetMapping("/employees")
    public List<AccountType> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public AccountType createEmployee(@Valid @RequestBody AccountType employee) {
        return employeeRepository.save(employee);
    }


}