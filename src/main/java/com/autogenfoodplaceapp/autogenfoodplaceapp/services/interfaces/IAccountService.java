package com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces;

import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;

public interface IAccountService extends Service<Account> {
    Account createOne(Account account, int accType);
}
