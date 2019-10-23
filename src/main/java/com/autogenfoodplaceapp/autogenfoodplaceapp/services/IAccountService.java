package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account getOne(int Id);

    Account createOne(Account account, int accType);
}
