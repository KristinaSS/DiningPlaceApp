package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.EntityNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sun.security.x509.AlgIdDSA;

import java.util.List;

@Log4j2
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
        return accountTypeRepository.findById(Id) .orElseGet(()->{
            try {
                throw new EntityNotFoundException(AccountType.class);
            } catch (EntityNotFoundException e) {
                log.warn("A account type with this Id has not been found:  {}", Id);
            }
            return null;
        });
    }

    @Override
    public AccountType createOne(AccountType accountType) {
        log.info("New account type has been created: {}", accountType);
        return accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteByID(int ID) {
        AccountType accountType = getOne(ID);
        if(accountType == null) {
            try {
                throw new EntityNotFoundException(AccountType.class);
            } catch (EntityNotFoundException e) {
                log.warn("Account Type not found: {}", ID);
            }
            return;
        }
        log.info("Deleted account type: {} ",ID);
        accountTypeRepository.delete(accountType);
    }

    @Override
    public AccountType updateByID(int ID, AccountType updatedAccountType) {
        return accountTypeRepository.findById(ID)
                .map(accountType -> accountTypeRepository.save(updateAccountTypeMembers(accountType,updatedAccountType)))
                .orElseGet(()->{
                    updatedAccountType.setAccountTypeID(ID);
                    log.info("New account has been created: {}",ID);
                    return accountTypeRepository.save(updatedAccountType);
                });
    }

    private AccountType updateAccountTypeMembers(AccountType accountType, AccountType updatedAccountType){
        accountType.setName(updatedAccountType.getName());
        log.info("Account type updated: {}", accountType);
        return accountType;
    }
}
