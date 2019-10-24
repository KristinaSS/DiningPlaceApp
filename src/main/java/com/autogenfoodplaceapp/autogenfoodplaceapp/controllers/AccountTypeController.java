package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("")
public class AccountTypeController {
    @Autowired
    IAccountTypeService accountTypeService;

    @GetMapping("/c")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountType> getAllAccountTypes() {
        return accountTypeService.findAll();
    }

    @PostMapping("/accountType")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountType createAccountType(@Valid @RequestBody AccountType accountType) {
        return accountTypeService.createOne(accountType);
    }
}