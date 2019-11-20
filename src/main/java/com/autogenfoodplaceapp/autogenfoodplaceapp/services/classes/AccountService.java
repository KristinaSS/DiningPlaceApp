package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.exceptions.EntityNotFoundException;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.AccountType;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import com.autogenfoodplaceapp.autogenfoodplaceapp.utils.MD5;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                        throw new EntityNotFoundException(Account.class);
                    } catch (EntityNotFoundException e) {
                        log.warn("Account not found: {}", Id);
                    }
                    return null;
                });
    }

    @Override
    public void deleteByID(int ID) {
        Account account = getOne(ID);
        if(account== null) {
            try {
                throw new EntityNotFoundException(Account.class);
            } catch (EntityNotFoundException e) {
                log.warn("Account not found: {}", ID);
            }
            return;
        }
        accountRepository.delete(account);
        log.debug("Deleted account with id: "+ID);
    }

    @Override
    public Account updateByID(int ID, Account updatedAccount) {
        return accountRepository.findById(ID)
                .map(account -> accountRepository.save(updateAccMembers(account,updatedAccount)))
                .orElseGet(()->{
                    updatedAccount.setAccID(ID);
                    log.debug("New account has been created with ID: {}",ID);
                    return accountRepository.save(updatedAccount);
                });
    }

    @Override
    public Account createOne(Account account, int accType) {

        AccountType accountType = accountTypeRepository.getOne(accType);
        Account hashedPasswordAcc = new Account();

        updateAccMembers(hashedPasswordAcc,account);
        hashedPasswordAcc.setAccountType(accountType);

        System.out.println("Enter 6" + hashedPasswordAcc.toString());

        log.debug("New account has been created: {}", hashedPasswordAcc);

        return accountRepository.save(hashedPasswordAcc);
    }

    //todo fix this
    @Override
    @Deprecated
    public Account createOne(Account entity) {
        return null;
    }

    private Account updateAccMembers (@NotNull Account hashPassAcc, @NotNull Account updatedAccount){
        hashPassAcc.setFirstName(updatedAccount.getFirstName());
        hashPassAcc.setLastName(updatedAccount.getLastName());
        hashPassAcc.setAccountType(updatedAccount.getAccountType());
        hashPassAcc.setEmail(updatedAccount.getEmail());
        hashPassAcc.setPassword(updatedAccount.getPassword());
        log.info("Account Updated: {}", hashPassAcc);
        return hashPassAcc;
    }
}
