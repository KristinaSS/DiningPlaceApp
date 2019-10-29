package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.ResourceNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw new ResourceNotFoundException("A account type with this Id has not been found:  "+ Id);
            } catch (ResourceNotFoundException e) {
                log.warn("An excetion was thrown "+ e.getClass()+ e.getMessage());
            }
            return null;
        });
    }

    @Override
    public AccountType createOne(AccountType accountType) {
        log.info("New account type has been created.");
        return accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteByID(int ID) {
        AccountType accountType = getOne(ID);
        if(accountType == null) {
            log.warn("No account has been deleted.");
            return;
        }
        log.info("Deleted account type with id: "+ID);
        accountTypeRepository.delete(accountType);
    }

    @Override
    public AccountType updateByID(int ID, AccountType updatedAccountType) {
        return accountTypeRepository.findById(ID)
                .map(accountType -> accountTypeRepository.save(updateAccountTypeMembers(accountType,updatedAccountType)))
                .orElseGet(()->{
                    updatedAccountType.setAccountTypeID(ID);
                    log.info("New account has been created with ID: "+ID);
                    return accountTypeRepository.save(updatedAccountType);
                });
    }

    private AccountType updateAccountTypeMembers(AccountType accountType, AccountType updatedAccountType){
        accountType.setName(updatedAccountType.getName());
        log.info("Account type updated.");
        return accountType;
    }
}
