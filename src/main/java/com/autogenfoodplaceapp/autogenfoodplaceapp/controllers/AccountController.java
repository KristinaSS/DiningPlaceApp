package com.autogenfoodplaceapp.autogenfoodplaceapp.controllers;

import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.Repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @GetMapping("/account")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/account")
    public Account createAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }
    @PostMapping("/account/{typeId}")
    public Account createAccount(@Valid @RequestBody Account account,@PathVariable(value = "typeId") Integer typeId) {
        account.setAccountType(accountTypeRepository.getOne(typeId));
        return accountRepository.save(account);
    }
}