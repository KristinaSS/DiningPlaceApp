package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("")
public class AccountController {
    @Autowired
    IAccountService accountService;

    @GetMapping("/account")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @PostMapping("/account/{typeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account,@PathVariable(value = "typeId") Integer typeId) {
        return accountService.createOne(account,typeId);
    }

    @PutMapping("/edit-acc-{accID}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(@PathVariable(value = "accID") Integer ID,
    @Valid @RequestBody Account account){
        return accountService.updateByID(ID,account);
    }

}