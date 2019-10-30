package com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes;

import org.junit.Test;


public class AccountServiceTest {
    @Test
    public void findAllTest() throws Exception {
/*
        when(accountRepository.findAll()).thenReturn(
                Collections.emptyList()
        );

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/account")
                .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());

        verify(accountRepository).findAll();
        List<Account> accountList = accountRepository.findAll();

        assertEquals(accountList,accountService.findAll());

}

    @Test
    public void getOneTest() {
        int accountID = 1;
        Account account = accountRepository.getOne(accountID);

        assertEquals(account,accountService.getOne(accountID));
    }

    @Test
    public void deleteByIDTest() {
        int accountID = 2;
        accountService.deleteByID(accountID);

        assertFalse(accountRepository.existsById(accountID));
    }

    @Test
    public void updateByIDTest() {
        AccountType accountType = accountTypeRepository.getOne(1);
        Account updatedAccount = new Account(
                accountType,
                "Kristina",
                "Stoyanova",
                "kristina.stoyanova",
                "root");
        int accountID = 1;
        Account oldAccount  = accountRepository.getOne(accountID);

        assertNotEquals(accountService.updateByID(accountID,updatedAccount),oldAccount);
    }

    @Test
    public void createOneTest() {
        AccountType accountType = accountTypeRepository.getOne(1);
        Account createdAccount = new Account(
                "Test",
                "Test",
                "kristina.test",
                "test");

        long repositorySize = accountRepository.count();

        Account account = accountService.createOne(createdAccount,1);

        assertTrue(accountRepository.existsById(account.getAccID()));

        assertEquals(repositorySize+1, accountRepository.count());
    }
*/

    }
}
