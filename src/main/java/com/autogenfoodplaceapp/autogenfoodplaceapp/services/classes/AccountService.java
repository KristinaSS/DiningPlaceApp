package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.ResourceNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Log4j2
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
                        log.warn("An excetion was thrown "+ e.getClass()+ e.getMessage());
                    }
                    return null;
                });
    }

    @Override
    public void deleteByID(int ID) {
        Account account = getOne(ID);
        if(account== null) {
            log.warn("No account has been deleted.");
            return;
        }
        accountRepository.delete(account);
        log.info("Deleted account with id: "+ID);
    }

    @Override
    public Account updateByID(int ID, Account updatedAccount) {
        return accountRepository.findById(ID)
                .map(account -> accountRepository.save(updateAccMembers(account,updatedAccount)))
                .orElseGet(()->{
                    updatedAccount.setAccID(ID);
                    log.info("New account has been created with ID: "+ID);
                    return accountRepository.save(updatedAccount);
                });
    }

    @Override
    public Account createOne(Account account, int accType) {
        account.setAccountType(accountTypeRepository.getOne(accType));

        log.info("New account has been created.");

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
        log.info("Account Updated");
        return account;
    }
}
