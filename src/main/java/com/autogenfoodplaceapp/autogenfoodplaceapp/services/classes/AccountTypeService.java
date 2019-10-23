package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService implements IAccountTypeService {
    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> findAll() {
        return accountTypeRepository.findAll();
    }

    @Override
    public AccountType getOne(int Id) {
        return accountTypeRepository.getOne(Id);
    }

    @Override
    public AccountType createOne(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }
}
