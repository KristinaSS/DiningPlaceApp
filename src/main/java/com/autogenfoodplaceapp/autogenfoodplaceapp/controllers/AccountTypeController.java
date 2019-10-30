package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("")
public class AccountTypeController {
    @Autowired
    IAccountTypeService accountTypeService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountType> getAllAccountTypes() {
        log.debug("REST request to get all AccountTypes");
        return accountTypeService.findAll();
    }

    @PostMapping("/accountType")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountType createAccountType(@Valid @RequestBody AccountType accountType) {
        log.debug("REST request to save Account Type : {}", accountType);
        return accountTypeService.createOne(accountType);
    }
}