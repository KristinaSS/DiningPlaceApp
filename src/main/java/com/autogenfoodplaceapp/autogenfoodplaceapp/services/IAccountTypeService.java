package com.autogenfoodplaceapp.autogenfoodplaceapp.services;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;

import java.util.List;

public interface IAccountTypeService {
    List<AccountType> findAll();

    AccountType getOne(int Id);

    AccountType createOne(AccountType accountType);
}
