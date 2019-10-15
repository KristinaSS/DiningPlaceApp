package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class AccountTypeController {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @GetMapping("/c")
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    @PostMapping("/accountType")
    public AccountType createAccountType(@Valid @RequestBody AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }


}