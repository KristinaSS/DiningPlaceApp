package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @PostMapping("/account/{typeId}")
    public Account createAccount(@Valid @RequestBody Account account,@PathVariable(value = "typeId") Integer typeId) {
        return accountService.createOne(account,typeId);
    }
}