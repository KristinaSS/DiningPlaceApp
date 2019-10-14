package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @GetMapping("/accountType")
    public List<AccountType> getAllEmployees() {
        return accountTypeRepository.findAll();
    }

    @PostMapping("/accountType")
    public AccountType createEmployee(@Valid @RequestBody AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }


}