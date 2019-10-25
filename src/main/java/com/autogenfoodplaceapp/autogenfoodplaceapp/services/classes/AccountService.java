package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.ResourceNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getOne(int Id) {
        return accountRepository.findById(Id)
                .orElseGet(()->{
                    try {
                        throw new ResourceNotFoundException(" A account with this Id has not been found:  "+ Id);
                    } catch (ResourceNotFoundException e) {
                        LOGGER.warn("An excetion was thrown "+ e.getClass()+ e.getMessage());
                    }
                    return null;
                });
    }

    @Override
    public void deleteByID(int ID) {
        Account account = getOne(ID);
        if(account== null) {
            LOGGER.warn("No account has been deleted.");
            return;
        }
        accountRepository.delete(account);
        LOGGER.info("Deleted account with id: "+ID);
    }

    @Override
    public Account updateByID(int ID, Account updatedAccount) {
        return accountRepository.findById(ID)
                .map(account -> accountRepository.save(updateAccMembers(account,updatedAccount)))
                .orElseGet(()->{
                    updatedAccount.setAccID(ID);
                    LOGGER.info("New account has been created with ID: "+ID);
                    return accountRepository.save(updatedAccount);
                });
    }

    @Override
    public Account createOne(Account account, int accType) {
        account.setAccountType(accountTypeRepository.getOne(accType));

        LOGGER.info("New account has been created.");

        return accountRepository.save(account);
    }

    //todo fix this
    @Override
    @Deprecated
    public Account createOne(Account entity) {
        return null;
    }

    private Account updateAccMembers (@NotNull Account account, @NotNull Account updatedAccount){
        account.setFirstName(updatedAccount.getFirstName());
        account.setLastName(updatedAccount.getLastName());
        account.setAccountType(updatedAccount.getAccountType());
        account.setEmail(updatedAccount.getEmail());
        account.setPassword(updatedAccount.getPassword());
        LOGGER.info("Account Updated");
        return account;
    }
}
