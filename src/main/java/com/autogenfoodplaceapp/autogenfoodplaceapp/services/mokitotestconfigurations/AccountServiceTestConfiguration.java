package com.autogenfoodplaceapp.autogenfoodplaceapp.services.mokitotestconfigurations;

import org.mockito.Mockito;
import com.autogenfoodplaceapp.autogenfoodplaceapp.services.classes.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("acc-test")
@Configuration
public class AccountServiceTestConfiguration {

    @Bean
    @Primary
    public AccountService accountService(){
        return Mockito.mock(AccountService.class);
    }
}
