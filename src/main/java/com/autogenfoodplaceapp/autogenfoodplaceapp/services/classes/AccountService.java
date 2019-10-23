package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.models.Account;
import com.autogenfoodplaceapp.autogenfoodplaceapp.repository.AccountTypeRepository;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;


    @Override
    public List<Account> findAll() {
        System.out.println(accountRepository.findAll().size());
        return accountRepository.findAll();
    }

    @Override
    public Account getOne(int Id) {
        System.out.println(Id);
        System.out.println(accountRepository.findAll().size());
        return accountRepository.getOne(Id);
    }

    @Override
    public Account createOne(Account account, int accType) {
        account.setAccountType(accountTypeRepository.getOne(accType));
        return accountRepository.save(account);
    }

    //not used yet

/*    public int findAccount(String email){
        for(Account account: accountRepository.findAll()){
            if(account.getEmail().equals(email)){
                return account.getAccID();
            }       }
        return -1;
    }

    public boolean isAuthorizedtoEnterAccount(int accID, String password){
        return accountRepository.getOne(accID).getPassword().equals(password);
    }*/
}
